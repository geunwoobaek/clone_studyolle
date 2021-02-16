//package clone.studyolle.app.modules.main;
//
//import clone.studyolle.app.modules.account.Account;
//import clone.studyolle.app.modules.account.AccountRepository;
//import clone.studyolle.app.modules.account.CurrentAccount;
//import clone.studyolle.app.modules.study.StudyRepository;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.web.PageableDefault;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@Slf4j
//@ControllerAdvice
//public class MainController {
////    private final StudyRepository studyRepository;
////    private final EnrollmentRepository enrollmentRepository;
////    private final AccountRepository accountRepository;
//
//
//    @GetMapping("/")
//    public String home(@CurrentAccount Account account, Model model) {
//        if (account != null) { //로그인했을시
//            Account accountLoaded = accountRepository.findAccountWithTagsAndZonesById(account.getId());
//
//        }
//    }
//
//    @GetMapping("/login")
//    public String login() {
//        return "login";
//    }
//
//    @GetMapping("/search/study")
//    public String searchStudy(String keyword, Model model,
//                              @PageableDefault(size = 9, sort = "publishedDateTime", direction = Sort.Direction.DESC)
//                                      Pageable pageable) {
//        Page<Study> studyPage = studyRepository.findByKeyword(keyword, pageable);
//
//    }
//}
