package com.spring.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
public class ApiSystem {

    @GetMapping("myAdmin")
    public String admin(){
        return "I am Admin";
    }
    @GetMapping("myAdminManager")
    public String adminOrManager() {
        return "I am Admin || Manager";
    }

    @GetMapping("myAdminManagerUser")
     public String adminOrManagerOrUser(){
        return "I am Admin || Manager || user";
    }
}
