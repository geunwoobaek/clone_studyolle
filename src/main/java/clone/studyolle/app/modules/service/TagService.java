package clone.studyolle.app.modules.service;

import clone.studyolle.app.modules.domain.Tag;
import clone.studyolle.app.modules.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class TagService {
    private final TagRepository tagRepository;
    public Tag findOrCreateNew(String tagTitle) {
        Tag tag=tagRepository.findByTitle((tagTitle));
        if(tag==null) {
            tag=new Tag();
            tag.setTitle(tagTitle);
            tag=tagRepository.save(tag);
        }
        return tag;
    }
}
