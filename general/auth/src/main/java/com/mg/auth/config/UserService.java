//package com.mg.auth.config;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.stereotype.Component;
//
//@Slf4j
//@EnableWebSecurity
//@Configuration
//public class UserService implements UserDetailsService {
//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        log.info("1111111111111111.................." + s);
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        String finalPassword = "{bcrypt}"+bCryptPasswordEncoder.encode("123456");
//        log.info("2222222222.................." + finalPassword);
//        return User.withUsername("matao").password(finalPassword).authorities("USER").build();
//    }
//}
