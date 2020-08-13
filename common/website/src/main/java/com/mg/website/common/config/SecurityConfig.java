package com.mg.website.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class SecurityConfig {

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {

        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();

        String key ="-----BEGIN PUBLIC KEY-----"+
                "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjOHeX0BnvWd6qTILwSYhpX7E3xAvv4uDcg6iHeJmlDmJXzzKqIhbHwJsPcqlSj282qN8P/7bUp79xMu2o5FUy2ES0gzMR1aCKfBviv9zBJ5lRPcs/TogOmtdycok5krdEkrFPMTcLYvCEw9DXo0sxK/k0USvn5gS1MSBTkvTxHGEGtxkg0jXJxNJlMi6QL4ZkYeyb4P7yld2AxP5igEkow4RE+CRLFE5EI66ZZfUOZdbaCXQGQJflr63EYhHNjXLTAU/8Nylc77OKzvaI3N8E0fOWaDVCxHIuuS9RRGglfl3xqs2UHBiIZdRjnGK0gWsk4a6PENsgP8bM52LzjgibQIDAQAB"
                +"-----END PUBLIC KEY-----";
        converter.setVerifier(new RsaVerifier(key));
        return converter;
    }

}
