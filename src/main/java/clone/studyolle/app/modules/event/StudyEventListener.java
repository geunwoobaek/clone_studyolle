package clone.studyolle.app.modules.event;

import clone.studyolle.app.infra.config.AppProperties;
import clone.studyolle.app.infra.email.EmailMessage;
import clone.studyolle.app.infra.email.EmailService;
import clone.studyolle.app.modules.account.Account;
import clone.studyolle.app.modules.account.AccountPredicates;
import clone.studyolle.app.modules.account.AccountRepository;
import clone.studyolle.app.modules.notification.Notification;
import clone.studyolle.app.modules.notification.NotificationRepository;
import clone.studyolle.app.modules.notification.NotificationType;
import clone.studyolle.app.modules.study.Study;
import clone.studyolle.app.modules.study.StudyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Slf4j
@Async
@Component
@Transactional
@RequiredArgsConstructor
public class StudyEventListener { //그냥 @component만 붙이면됨
    private final StudyRepository studyRepository;
    private final AccountRepository accountRepository;
    private final EmailService emailService;
    private final TemplateEngine templateEngine;
    private final AppProperties appProperties;
    private final NotificationRepository notificationRepository;

    @EventListener
    public void handleStudyCreatedEvent(StudyCreatedEvent studyCreatedEvent) { //스터디 생성 됐을때 실행
        Study study = studyRepository.findStudyWithTagsAndZonesById((studyCreatedEvent.getStudy().getId()));//해당 스터디 찾기
        //해당태그를 등록한 모든 사람들에게 알림
        Iterable<Account> accounts = accountRepository.findAll(AccountPredicates.findByTagsAndZones(study.getTags(), study.getZones()));
        accounts.forEach(account -> {
            if (account.isStudyCreatedByEmail()) {
                sendStudyCreatedEmail(study, account, "새로운 스터디가 생겼습니다"
                        , "스터디올래, '" + study.getTitle() + "' 스터디가 생겼습니다.");
            }
            if (account.isStudyCreatedByWeb()) {
                createNotification(study, account, study.getShortDescription(), NotificationType.STUDY_CREATED);
            }
        });
    }

    @EventListener
    public void handleStudyUpdatedEvent(StudyUpdateEvent studyUpdateEvent) {
        Study study = studyRepository.findStudyWithManagersAndMemebersById(studyUpdateEvent.getStudy().getId());
        Set<Account> accounts = new HashSet<>();
        accounts.addAll(study.getManagers());
        accounts.addAll(study.getMembers());
        accounts.forEach(account -> {
            if (account.isStudyUpdatedByEmail()) {
                sendStudyCreatedEmail(study, account, studyUpdateEvent.getMessage(),
                        "스터디올래, '" + study.getTitle() + "' 스터디에 새소식이 있습니다.");
            }

            if (account.isStudyUpdatedByWeb()) {
                createNotification(study, account, studyUpdateEvent.getMessage(), NotificationType.STUDY_UPDATED);
            }
        });


    }

    public void createNotification(Study study, Account account, String shortDescription, NotificationType studyCreated) {

        Notification notification = new Notification();
        notification.setTitle(study.getTitle());
        notification.setLink("/study/" + study.getEncodedPath());
        notification.setChecked(false);
        notification.setCreatedDateTime(LocalDateTime.now());
        notification.setMessage(shortDescription);
        notification.setAccount(account);
        notification.setNotificationType(studyCreated);
        notificationRepository.save(notification);
    }

    private void sendStudyCreatedEmail(Study study, Account account, String contextMessage, String emailSubject) {
        Context context = new Context();
        context.setVariable("nickname", account.getNickname());
        context.setVariable("link", "/study/" + study.getEncodedPath());
        context.setVariable("linkName", study.getTitle());
        context.setVariable("message", contextMessage);
        context.setVariable("host", appProperties.getHost());
        String message = templateEngine.process("mail/simple-link", context);

        EmailMessage emailMessage = EmailMessage.builder()
                .subject(emailSubject)
                .to(account.getEmail())
                .message(message)
                .build();
        emailService.sendEmail(emailMessage);
    }
}
