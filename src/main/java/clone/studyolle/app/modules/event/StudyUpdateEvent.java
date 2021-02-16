package clone.studyolle.app.modules.event;

import clone.studyolle.app.modules.study.Study;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class StudyUpdateEvent {
    private final Study study;
    private String message;
}
