package clone.studyolle.app.utils;

import clone.studyolle.app.domain.Account;
import clone.studyolle.app.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountFactory {

    private final AccountRepository accountRepository;

    public Account createAccount(String nickname) {
        Account geunwoo = new Account();
        geunwoo.setNickname(nickname);
        geunwoo.setEmail(nickname + "@email.com");
        accountRepository.save(geunwoo);
        return geunwoo;
    }
}
