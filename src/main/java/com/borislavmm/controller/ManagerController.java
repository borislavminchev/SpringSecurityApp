package com.borislavmm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/leaders")
public class ManagerController {


    @GetMapping("/leaderPage")
    public String leaderPage(){
        return "leaders";
    }
}
