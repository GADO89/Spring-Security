package com.spring.springsecurity.securityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class securityConfiguration extends WebSecurityConfigurerAdapter {

    private UserPrincipleDetailsService userPrincipleDetailsService;

    @Autowired
    public securityConfiguration( UserPrincipleDetailsService userPrincipleDetailsService) {
        this.userPrincipleDetailsService = userPrincipleDetailsService;
    }

    @Autowired


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());



    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    http
            .authorizeRequests()

            .antMatchers("/api/main").permitAll()
            .antMatchers("/api/profile").authenticated()
            .antMatchers("/api/admin/**").hasRole("ADMIN")
            .antMatchers("/api/manage").hasAnyRole("ADMIN","MANAGER")
            .antMatchers("/api/basic/mybasic").hasAuthority("ACCESS_BASIC1")
            .antMatchers("/api/basic/allbasic").hasAuthority("ACCESS_BASIC2")



            //.anyRequest().authenticated()
            .and()
            .formLogin()
            .loginPage("/api/login")
            .permitAll();


    }
    @Bean
    DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userPrincipleDetailsService);
        return daoAuthenticationProvider;
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new  BCryptPasswordEncoder();
    }
}
