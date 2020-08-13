package com.mg.website.common.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mg.website.common.pojo.bo.AuthUserBo;
import com.mg.website.common.util.AuthUtil;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

@Configuration
public class DefaultBean {


    @Bean
    @ConditionalOnMissingBean(AuthUtil.class)
    public AuthUtil getAuthUtil()
    {
        AuthUtil authUtil = new AuthUtil() {
            @Override
            public AuthUserBo getUser() {
                OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();
                String token = details.getTokenValue();
                String key ="-----BEGIN PUBLIC KEY-----"+
                        "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjOHeX0BnvWd6qTILwSYhpX7E3xAvv4uDcg6iHeJmlDmJXzzKqIhbHwJsPcqlSj282qN8P/7bUp79xMu2o5FUy2ES0gzMR1aCKfBviv9zBJ5lRPcs/TogOmtdycok5krdEkrFPMTcLYvCEw9DXo0sxK/k0USvn5gS1MSBTkvTxHGEGtxkg0jXJxNJlMi6QL4ZkYeyb4P7yld2AxP5igEkow4RE+CRLFE5EI66ZZfUOZdbaCXQGQJflr63EYhHNjXLTAU/8Nylc77OKzvaI3N8E0fOWaDVCxHIuuS9RRGglfl3xqs2UHBiIZdRjnGK0gWsk4a6PENsgP8bM52LzjgibQIDAQAB"
                        +"-----END PUBLIC KEY-----";
                Jwt jwt = JwtHelper.decodeAndVerify(token, new RsaVerifier(key));

                JSONObject userJson = (JSONObject) JSONObject.parse(jwt.getClaims());
                AuthUserBo bo = new AuthUserBo();
                bo.setUserName(userJson.getString("name"));

                return bo;
            }
        };

        return authUtil;
    }

}
