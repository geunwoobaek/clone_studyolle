package clone.studyolle.app.modules.account;

import lombok.RequiredArgsConstructor;
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
