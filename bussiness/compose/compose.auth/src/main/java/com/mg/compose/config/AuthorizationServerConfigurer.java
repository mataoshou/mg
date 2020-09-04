package com.mg.compose.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mg.common.action.MgApiException;
import com.mg.common.pojo.ResultItem;
import com.mg.common.util.ResultItemUtil;
import com.mg.compose.pojo.dto.InSysSiteDto;
import com.mg.compose.pojo.dto.OutSysSiteDto;
import com.mg.compose.service.feign.SysFeign;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.error.DefaultWebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableAuthorizationServer
@Slf4j
public class AuthorizationServerConfigurer  extends AuthorizationServerConfigurerAdapter {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    TokenStore tokenStore;

    @Autowired
    JwtAccessTokenConverter tokenConverter;


    @Autowired
    SysFeign feign;

    /**
     * 使用密码模式需要配置
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {

        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(
                Arrays.asList(customTokenEnhancer(),tokenConverter));

        endpoints
        .tokenStore(tokenStore)
        .tokenEnhancer(tokenEnhancerChain)
        .accessTokenConverter(tokenConverter)
        .authenticationManager(authenticationManager)
        .userDetailsService(userDetailsService)
        .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST)
        ;

        endpoints.exceptionTranslator(loggingExceptionTranslator());
    }

    @Bean
    public WebResponseExceptionTranslator loggingExceptionTranslator() {
        return new DefaultWebResponseExceptionTranslator() {
            @Override
            public ResponseEntity<OAuth2Exception> translate(Exception e) throws Exception {
                //异常堆栈信息输出
                log.error("异常堆栈信息", e);
                return new ResponseEntity(new ResultItem(HttpStatus.METHOD_NOT_ALLOWED.value(),e.getMessage()), HttpStatus.METHOD_NOT_ALLOWED);
            }
        };
    }

    @Bean
    public TokenEnhancer customTokenEnhancer()
    {
        return new CustomTokenEnhancer();
    }



    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients
//                .inMemory()//Token保存在内存中
//                .withClient("website").secret(passwordEncoder.encode("123456"))//指明client-id和client-secret
//                .accessTokenValiditySeconds(7200)//令牌有效时间，单位秒
//                .authorizedGrantTypes("refresh_token","password","authorization_code")//支持刷新令牌、密码模式、授权码模式
//                .scopes("all","read","write");//权限有哪些,如果这两配置了该参数，客户端发请求可以不带参数，使用配置的参数
////                .redirectUris("http://127.0.0.1:264/login");

        clients.withClientDetails(clientDetails());
    }

    @Bean
    public ClientDetailsService clientDetails() {
        return new ClientDetailsService() {
            @SneakyThrows
            @Override
            public ClientDetails loadClientByClientId(String s) throws ClientRegistrationException {

                BaseClientDetails details = new BaseClientDetails();

                InSysSiteDto dto = new InSysSiteDto();
                dto.setSiteName(s);
                Object result = feign.getByName(dto);
                ResultItem<OutSysSiteDto> item = feign.getByName(dto);
                OutSysSiteDto sysSite = ResultItemUtil.getDate(item);
                if(sysSite==null)return null;
                details = new BaseClientDetails(sysSite.getSiteName(),null,
                        "all,read,write",
                        "refresh_token,password,authorization_code",null);
                details.setClientSecret(passwordEncoder.encode(sysSite.getPassword()));
                details.setAccessTokenValiditySeconds(7200);
                return details;
            }
        };
    }


    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
                .checkTokenAccess("isAuthenticated()")
                .allowFormAuthenticationForClients();//允许表单认证

    }




}
