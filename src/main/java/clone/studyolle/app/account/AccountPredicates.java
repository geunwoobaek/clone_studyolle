package clone.studyolle.app.account;

import clone.studyolle.app.domain.*;
import com.querydsl.core.types.Predicate;
import java.util.Set;

public class AccountPredicates {

public static Predicate findByTagsAndZones(Set<Tag> tags,Set<Zone> zones){
    QAccount account = QAccount.account;
    return account.zones.any().in(zones).and(account.tags.any().in(tags));
}

}
