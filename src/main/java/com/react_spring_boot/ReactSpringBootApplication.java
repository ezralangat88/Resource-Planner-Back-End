package com.react_spring_boot;

import com.react_spring_boot.Role.Role;
import com.react_spring_boot.Services.UserService;
import com.react_spring_boot.User.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class ReactSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactSpringBootApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(1, "ROLE_USER"));
            userService.saveRole(new Role(3, "ROLE_ADMIN"));
            userService.saveRole(new Role(4, "ROLE_SUPER_ADMIN"));

//            userService.saveUser(new User(1, "James Trevor", "trevor", "1234", new ArrayList<>()));
//            userService.saveUser(new User(2, "Steve Curry", "curry", "1234", new ArrayList<>()));
//            userService.saveUser(new User(3, "Lebron james", "lebron", "1234", new ArrayList<>()));
//            userService.saveUser(new User(4, "Gaucho Ronaldinho", "gaucho", "1234", new ArrayList<>()));

//            userService.addRoleToUser("trevor", "ROLE_USER");
//            userService.addRoleToUser("curry", "ROLE_MANAGER");
//            userService.addRoleToUser("lebron", "ROLE_ADMIN");
//            userService.addRoleToUser("gaucho", "ROLE_SUPER_ADMIN");
//            userService.addRoleToUser("gaucho", "ROLE_ADMIN");
//            userService.addRoleToUser("gaucho", "ROLE_USER");
        };
    }

}
