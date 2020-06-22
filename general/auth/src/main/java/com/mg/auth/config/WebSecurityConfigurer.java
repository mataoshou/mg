package com.mg.auth.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Slf4j
@Configuration
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        String finalPassword = "{bcrypt}" + new BCryptPasswordEncoder().encode("123456");
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        log.info("11111111111.................." +finalPassword);
        manager.createUser(User.withUsername("mg1").password(finalPassword).authorities("USER").build());
        manager.createUser(User.withUsername("mg2").password(finalPassword).authorities("USER").build());

        return manager;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        AuthenticationManager manager = super.authenticationManagerBean();
        return manager;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.requestMatchers().anyRequest()
                .and()
                .authorizeRequests()
                .antMatchers("/oauth/**").permitAll();
    }

}
