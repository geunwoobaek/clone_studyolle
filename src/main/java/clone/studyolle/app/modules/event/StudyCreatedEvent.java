package clone.studyolle.app.modules.event;

import clone.studyolle.app.modules.study.Study;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class StudyCreatedEvent {
    private final Study study;
}
