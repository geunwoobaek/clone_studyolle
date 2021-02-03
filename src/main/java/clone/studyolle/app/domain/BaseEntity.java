package clone.studyolle.app.domain;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
//@EqualsAndHashCode(of="id")
public class BaseEntity {
    @Id
    @GeneratedValue
    private Long id;
}
