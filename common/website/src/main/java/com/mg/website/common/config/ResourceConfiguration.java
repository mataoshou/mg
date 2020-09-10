package com.mg.website.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.vote.AuthenticatedVoter;
import org.springframework.security.access.vote.UnanimousBased;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.web.access.expression.WebExpressionVoter;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class ResourceConfiguration  extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/sys/**","/free/**","/oauth/**").permitAll()
                .anyRequest().authenticated()
//                .antMatchers("/user").hasRole()
//                .and()
//                .authorizeRequests()
//                .accessDecisionManager(accessDecisionManager())
//                .and()
//                .authorizeRequests()
//                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
//                    @Override
//                    public <O extends FilterSecurityInterceptor> O postProcess(
//                            O fsi) {
//                        fsi.setSecurityMetadataSource(mySecurityMetadataSource(fsi.getSecurityMetadataSource()));
//                        return fsi;
//                    }
//                })
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

//    @Bean
//    public AccessDecisionManager accessDecisionManager() {
//        List<AccessDecisionVoter<? extends Object>> decisionVoters
//                = Arrays.asList(
//                new WebExpressionVoter(),
//                // new RoleVoter(),
//                new RoleVoter(),
//                new AuthenticatedVoter());
//        return new UnanimousBased(decisionVoters);
//    }

//    @Bean
//    public MyFilterSecurityMetadataSource mySecurityMetadataSource(FilterInvocationSecurityMetadataSource filterInvocationSecurityMetadataSource) {
//        MyFilterSecurityMetadataSource securityMetadataSource = new MyFilterSecurityMetadataSource();
//        return securityMetadataSource;
//    }

}
