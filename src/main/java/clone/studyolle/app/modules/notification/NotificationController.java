package clone.studyolle.app.modules.notification;

import clone.studyolle.app.modules.account.Account;
import clone.studyolle.app.modules.account.CurrentAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class NotificationController {
    private final NotificationRepository repository;

    private final NotificationService service;

    @GetMapping("/notifications") //읽지않은메시지에 대한 알림정보열람
    public String getNotifications(@CurrentAccount Account account, Model model) {
        //계정에 해당하는 읽지 않은것 Notification찾기
        List<Notification> notifications = repository.findByAccountAndCheckedOrderByCreatedDateTimeDesc(account, false);
        long numberOfChecked = repository.countByAccountAndChecked(account, true);
        putCategorizedNotifications(model, notifications, notifications.size(), numberOfChecked);
        model.addAttribute("isNew", false);
        service.markAsRead(notifications);
        return "notification/list";

    }

    @GetMapping("/notifications/old")
    public String getOldNotifications(@CurrentAccount Account account, Model model) {
        List<Notification> notifications = repository.findByAccountAndCheckedOrderByCreatedDateTimeDesc(account, true);
        long numberOfNotChecked = repository.countByAccountAndChecked(account, false);
        putCategorizedNotifications(model, notifications, notifications.size(), numberOfNotChecked);
        model.addAttribute("isNew", false);
        return "notification/list";
    }

    @DeleteMapping("/notifications")
    public String deleteNotifications(@CurrentAccount Account account) {
        repository.deleteByAccountAndChecked(account, true);
        return "redirect:/notifications";
    }

    private void putCategorizedNotifications(Model model, List<Notification> notifications,
                                             long numberOfChecked, long numberOfNotChecked) {
        List<Notification> newStudyNotifications = new ArrayList<>();
        List<Notification> eventEnrollmentNotifications = new ArrayList<>();
        List<Notification> watchingStudyNotifications = new ArrayList<>();
        for (var notification : notifications) {
            switch (notification.getNotificationType()) {
                case STUDY_CREATED:
                    newStudyNotifications.add(notification);
                    break;
                case EVENT_ENROLLMENT:
                    eventEnrollmentNotifications.add(notification);
                    break;
                case STUDY_UPDATED:
                    watchingStudyNotifications.add(notification);
                    break;
            }
        }
        model.addAttribute("numberOfNotChecked", numberOfNotChecked);
        model.addAttribute("numberOfChecked", numberOfChecked);
        model.addAttribute("notifications", notifications);
        model.addAttribute("newStudyNotifications", newStudyNotifications);
        model.addAttribute("eventEnrollmentNotifications", eventEnrollmentNotifications);
        model.addAttribute("watchingStudyNotifications", watchingStudyNotifications);

    }

}
