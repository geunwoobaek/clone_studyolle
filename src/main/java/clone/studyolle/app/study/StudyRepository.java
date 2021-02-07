package clone.studyolle.app.study;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly=true)
public interface StudyRepository extends JpaRepository<Study,Long>,StudyRepositoryExtension {
}
