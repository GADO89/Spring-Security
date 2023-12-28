package com.spring.springsecurity.securityconfig;

import com.spring.springsecurity.dao.UserRepository;
import com.spring.springsecurity.model.User;
import com.spring.springsecurity.model.UserPrinciple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserPrincipleDetailsService implements UserDetailsService {

    private UserRepository userRepository;
    @Autowired
    public UserPrincipleDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
       User user= userRepository.findByUserName(name);
        UserPrinciple userPrinciple=new UserPrinciple(user);
        return null;
    }
}
