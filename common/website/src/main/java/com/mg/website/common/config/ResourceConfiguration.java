package com.mg.website.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

@Configuration
@EnableResourceServer
public class ResourceConfiguration  extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/sys/**","/free/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .headers().contentTypeOptions().disable();
        http.csrf().disable();
    }

    @Autowired
    AuthExceptionHandler authExceptionHandler;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenServices(defaultTokenServices());
        resources.accessDeniedHandler(authExceptionHandler)
                .authenticationEntryPoint(authExceptionHandler);
    }

    @Autowired
    JwtAccessTokenConverter accessTokenConverter;

    @Autowired
    TokenStore tokenStore;

    @Bean
    public ResourceServerTokenServices defaultTokenServices() {
        final DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        // 使用自定义的Token转换器
        defaultTokenServices.setTokenEnhancer(accessTokenConverter);
        // 使用自定义的tokenStore
        defaultTokenServices.setTokenStore(tokenStore);
        return defaultTokenServices;
    }

}
