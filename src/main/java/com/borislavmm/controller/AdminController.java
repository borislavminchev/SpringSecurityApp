package com.borislavmm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/systems")
public class AdminController {


    @GetMapping("/adminPage")
    public String getAdminPage(){
        return "admins";
    }
}
