package clone.studyolle.app.controller;

import clone.studyolle.app.domain.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MainController {

    @GetMapping("/")
    public String home(){
        return "/";
    }
    @GetMapping("/login")
    public String login() {
        return "/login";
    }
//    @GetMapping("/sign-up")
//    public String sign() {
//        return "/sign-up";
//    }
    @GetMapping("/check-email")
    public String checkEmail() {
        return "/check-email";
    }
    @GetMapping("/check-email-token")
    public String checkEmailToken(){return"/check-email-token";}
    @GetMapping("/login-link")
    public String loginLink(){return"/login-link";}
    @GetMapping("/profile/*")
    public String getProfile(){return"/profile/*";}
    @PostMapping("/profile/*")
    public String postProfile(){return"/profile/*";}
}
