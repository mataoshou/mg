package com.mg.website.config;

import com.esotericsoftware.minlog.Log;
import com.mg.website.service.authe.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    AuthService service;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        Log.info("111111111111111111111111111111111111");
        http.authorizeRequests()
        .antMatchers("/sys/**").permitAll()
        .anyRequest().hasAuthority("mg")
        .and()
        .formLogin()
        .loginPage("/login").permitAll()
        .and()
        .logout().permitAll()
        .and()
        .headers().contentTypeOptions().disable();
        http.csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        Log.info("22222222222222222222222222222222222222222222");
        auth.userDetailsService(service);
    }
}
