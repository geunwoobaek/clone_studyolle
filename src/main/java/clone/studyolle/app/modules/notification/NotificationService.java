package clone.studyolle.app.modules.notification;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service
@RequiredArgsConstructor
public class NotificationService {
    private NotificationRepository notificationRepository;
    public void markAsRead(List<Notification> notifications) {
        notifications.forEach(n -> n.setChecked(true));
    }
}
