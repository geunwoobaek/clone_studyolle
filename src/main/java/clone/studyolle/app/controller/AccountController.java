package clone.studyolle.app.controller;

import clone.studyolle.app.form.SignUpForm;
import clone.studyolle.app.service.AccountService;
import clone.studyolle.app.validator.SignUpFormValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;

@Controller
@RequiredArgsConstructor
public class AccountController {
    private final SignUpFormValidator signUpFormValidator;
    private final AccountService accountService;

    @InitBinder("singUpForm")
    public void initBinder(WebDataBinder webDataBinder){webDataBinder.addValidators(signUpFormValidator);}

    @GetMapping("/sign-up")
    public String signupForm(Model model){
        model.addAttribute(new SignUpForm());
        return "account/sign-up";
    }
}
