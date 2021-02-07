package clone.studyolle.app.study.event;

import clone.studyolle.app.study.Study;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class StudyCreatedEvent {
    private final Study study;
}
