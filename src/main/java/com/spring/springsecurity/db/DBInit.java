package com.spring.springsecurity.db;

import com.spring.springsecurity.dao.AuthoritiesRepository;
import com.spring.springsecurity.dao.UserRepository;
import com.spring.springsecurity.model.Authorities;
import com.spring.springsecurity.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DBInit implements CommandLineRunner {

    private UserRepository userRepository;
    private AuthoritiesRepository authoritiesRepository;

    private PasswordEncoder passwordEncoder;

   // @Autowired
    public DBInit(UserRepository userRepository, AuthoritiesRepository authoritiesRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.authoritiesRepository = authoritiesRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {

       /*   this.userRepository.deleteAll();
        User admin=new User("ahmed", passwordEncoder.encode("ahmed123") ,"20","Alex",1);
        admin.setAuthorities( this.authoritiesRepository.findAll());
        userRepository.save(admin);
 ////////////////////////////////////////////////////////////////////////
        User manager=new User("yasser",passwordEncoder.encode("yasser123"),"20","Alex",1);

        Authorities managerAuthorities1=authoritiesRepository.findById(2L).get();
        Authorities managerAuthorities2=authoritiesRepository.findById(3L).get();
        Authorities managerAuthorities3=authoritiesRepository.findById(5L).get();
        Authorities managerAuthorities4=authoritiesRepository.findById(6L).get();


        manager.getAuthorities().add(managerAuthorities1);
        manager.getAuthorities().add(managerAuthorities2);
        manager.getAuthorities().add(managerAuthorities3);
        manager.getAuthorities().add(managerAuthorities4);

        userRepository.save(manager);
        ////////////////////////////////////////////
        User user=new User("karim",passwordEncoder.encode("karim123"),"20","Alex",1);
        Authorities userAuthorities1=authoritiesRepository.findById(3L).get();
        Authorities userAuthorities2=authoritiesRepository.findById(6L).get();
        user.getAuthorities().add(userAuthorities2);
        userRepository.save(user); */







    }
}
