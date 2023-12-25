package com.spring.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/api")
public class LoginController {

    @GetMapping("/main")
    public String login(){
        return "index";
    }
    @GetMapping("/profile")
    public String index(){
        return "profile/index";
    }

    @GetMapping("/manage")
    public String fragments(){
        return "management/index";
    }
    @GetMapping("/admin")
    public String admin(){
        return "admin/index";
    }


}
