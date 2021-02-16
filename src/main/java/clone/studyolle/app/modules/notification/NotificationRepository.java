package clone.studyolle.app.modules.notification;

import clone.studyolle.app.modules.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByAccountAndCheckedOrderByCreatedDateTimeDesc(Account account, Boolean checked);
    @Transactional(readOnly = true)
    long countByAccountAndChecked(Account account, Boolean checked);
    void deleteByAccountAndChecked(Account account,Boolean checked);
}
