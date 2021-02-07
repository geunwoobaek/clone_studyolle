package clone.studyolle.app.repository;


import clone.studyolle.app.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly= true)
public interface TagRepository  extends JpaRepository<Tag,Long> {
    Tag findByTitle(String title);
}
