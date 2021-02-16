package clone.studyolle.app.modules.notification;

import clone.studyolle.app.modules.account.Account;
import lombok.*;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@EqualsAndHashCode(of = "id")
public class Notification {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Account account;
    private LocalDateTime createdDateTime;
    private Boolean checked = false;
    private String title;
    private String link;
    private String message;
    @Enumerated(EnumType.STRING)
    private NotificationType notificationType;

}
