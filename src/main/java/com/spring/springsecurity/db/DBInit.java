package com.spring.springsecurity.db;

import com.spring.springsecurity.dao.AuthoritiesRepository;
import com.spring.springsecurity.dao.RoleRepository;
import com.spring.springsecurity.dao.UserRepository;
import com.spring.springsecurity.model.Authorities;
import com.spring.springsecurity.model.Role;
import com.spring.springsecurity.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class DBInit implements CommandLineRunner {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private AuthoritiesRepository authoritiesRepository;

    @Autowired
    public DBInit(UserRepository userRepository, RoleRepository roleRepository, AuthoritiesRepository authoritiesRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.authoritiesRepository = authoritiesRepository;
    }



    @Override
    public void run(String... args) throws Exception {
        User user=this.userRepository.findByUserName("karim");
        System.out.println(user.getAddress());
         /*this.userRepository.deleteAll();
        User admin=new User("ahmed","ahmed123","20","Alex",1);
        admin.setRoles( this.roleRepository.findAll());
        admin.setAuthorities( this.authoritiesRepository.findAll());
        userRepository.save(admin);
 ////////////////////////////////////////////////////////////////////////
        User manager=new User("yasser","yasser123","20","Alex",1);
        Role managerRoles1=roleRepository.findById(2L).get();
        Role managerRoles2=roleRepository.findById(3L).get();
        Authorities managerAuthorities1=authoritiesRepository.findById(2L).get();
        Authorities managerAuthorities2=authoritiesRepository.findById(3L).get();
        manager.getRoles().add(managerRoles1);
        manager.getRoles().add(managerRoles2);
        manager.getAuthorities().add(managerAuthorities1);
        manager.getAuthorities().add(managerAuthorities2);
        userRepository.save(manager);
        ////////////////////////////////////////////
        User user=new User("karim","karim123","20","Alex",1);
        Role userRoles1=roleRepository.findById(3L).get();
        Authorities userAuthorities1=authoritiesRepository.findById(3L).get();
        user.getRoles().add(userRoles1);
        user.getAuthorities().add(userAuthorities1);
        userRepository.save(user); */








    }
}
