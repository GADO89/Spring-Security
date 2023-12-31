package com.spring.springsecurity.controller;

import com.spring.springsecurity.model.JwtLogin;
import com.spring.springsecurity.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class LoginController {

   private TokenService tokenService;

    @Autowired
    public LoginController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping("/signup")
     public String login(@RequestBody JwtLogin jwtLogin) throws Exception {
        return tokenService.successfulAuthentication(jwtLogin);
    }
}
