package com.spring.springsecurity.securityconfig;

import com.spring.springsecurity.dao.UserRepository;
import com.spring.springsecurity.securityconfig.jwt.JwtAuthenticationFilter;
import com.spring.springsecurity.securityconfig.jwt.JwtAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private UserPrincipleDetailsService userPrincipleDetailsService;

    private UserRepository userRepository;

    @Autowired
    public SecurityConfiguration(UserPrincipleDetailsService userPrincipleDetailsService, UserRepository userRepository) {
        this.userPrincipleDetailsService = userPrincipleDetailsService;
        this.userRepository = userRepository;
    }



    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
   public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());



    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    http
            .csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .addFilter(new JwtAuthorizationFilter(authenticationManager(),this.userRepository ))
            .authorizeRequests()
            .antMatchers(HttpMethod.POST, "/login").permitAll()
            .antMatchers(HttpMethod.POST, "/signup").permitAll()
            .antMatchers("/api/myAdmin").hasRole("ADMIN")
            .antMatchers("/api/myAdminManager").hasAnyRole("ADMIN", "MANAGER")
            .antMatchers("/api/myAdminManagerUser").hasAnyRole("ADMIN", "MANAGER", "USER")
            .anyRequest().authenticated();

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
