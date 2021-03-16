package com.borislavmm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/showLoginPage")
    public String showLogin() {
        return "fancy-login";
    }

    @GetMapping("/accessDenied")
    public String accessDeniedPage(){
        return "access-denied";
    }
}
