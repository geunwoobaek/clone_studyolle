package clone.studyolle.app.modules.account;


import clone.studyolle.app.infra.MockMvcTest;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@MockMvcTest
public class AccountServiceTest {
    @Autowired
    AccountService accountService;
    Account account,account2;
    @Autowired
    PersistentTokenRepository tokenRepository;
    @BeforeEach
    void Init(){
        account=new Account()
                .builder()
                .email("geunwoo@naver.com")
                .nickname("geunwoo")
                .password("asdasd")
                .build();
        account2=new Account()
                .builder()
                .email("minsogoing@naver.com")
                .nickname("jiyeon")
                .password("park~@")
                .build();
    }
    @Test
    void SignUpTest(){
        accountService.completeSignUp(account);
    }
    @Test
    void LoginTest(){
        accountService.login(account);
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication);
        accountService.login(account2);
        authentication=SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication);
    }
}
