package clone.studyolle.app.modules.event;

import clone.studyolle.app.modules.account.Account;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@NamedEntityGraph(
        name = "Enrollment.withEventAndStudy",
        attributeNodes = {
                @NamedAttributeNode(value = "event", subgraph = "study")
        },
        subgraphs = @NamedSubgraph(name = "study", attributeNodes = @NamedAttributeNode("study"))
)
@Entity @Data
@EqualsAndHashCode(of="id")
public class Enrollment {
    @Id @GeneratedValue
    private Long id;

    private boolean accepted;

    @ManyToOne
    Account account;
}
