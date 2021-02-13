//package clone.studyolle.app.modules.study.event;
//
//import clone.studyolle.app.infra.config.AppProperties;
//import clone.studyolle.app.modules.account.AccountRepository;
//import clone.studyolle.app.modules.repository.NotificationRepository;
//import clone.studyolle.app.modules.study.StudyRepository;
//import clone.studyolle.app.infra.email.EmailService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.event.EventListener;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.stereotype.Component;
//import org.thymeleaf.TemplateEngine;
//
//import javax.transaction.Transactional;
//
//@Slf4j
//@Async
//@Component
//@Transactional
//@RequiredArgsConstructor
//public class StudyEventListener {
//
//    private final StudyRepository studyRepository;
//    private final AccountRepository accountRepository;
//    private final EmailService emailService;
//    private final TemplateEngine templateEngine;
//    private final AppProperties appProperties;
//    private final NotificationRepository notificationRepository;
//
//    @EventListener
//    public void handleStudyCreatedEvent(StudyCreatedEvent studyCreatedEvent) {
//      //  Study study= studyRepository.
//
//    }
//}
