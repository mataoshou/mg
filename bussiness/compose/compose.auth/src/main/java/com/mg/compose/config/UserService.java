package com.mg.compose.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Slf4j
//@EnableWebSecurity
@Component
public class UserService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("登录用户名："+username);
        String  password = passwordEncoder.encode("123456");
        UserDetails user = new User(username,password,true,true,true,true,
        AuthorityUtils.commaSeparatedStringToAuthorityList("admin,ROLE_USER"));
//        User user = new User(username,password, AuthorityUtils.commaSeparatedStringToAuthorityList("admin,ROLE_USER"));

        return user;
    }
}
