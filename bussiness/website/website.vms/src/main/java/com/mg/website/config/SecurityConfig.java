package com.mg.website.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

@Configuration
public class SecurityConfig {

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
//        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//        converter.setSigningKey("123");
//        return converter;

//        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//        KeyStoreKeyFactory keyStoreKeyFactory =
//                new KeyStoreKeyFactory(new ClassPathResource("shineon.jks"), "shineon".toCharArray());
//        converter.setKeyPair(keyStoreKeyFactory.getKeyPair("shineon"));
//        return converter;

        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();

        String key ="-----BEGIN PUBLIC KEY-----"+
                "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjOHeX0BnvWd6qTILwSYhpX7E3xAvv4uDcg6iHeJmlDmJXzzKqIhbHwJsPcqlSj282qN8P/7bUp79xMu2o5FUy2ES0gzMR1aCKfBviv9zBJ5lRPcs/TogOmtdycok5krdEkrFPMTcLYvCEw9DXo0sxK/k0USvn5gS1MSBTkvTxHGEGtxkg0jXJxNJlMi6QL4ZkYeyb4P7yld2AxP5igEkow4RE+CRLFE5EI66ZZfUOZdbaCXQGQJflr63EYhHNjXLTAU/8Nylc77OKzvaI3N8E0fOWaDVCxHIuuS9RRGglfl3xqs2UHBiIZdRjnGK0gWsk4a6PENsgP8bM52LzjgibQIDAQAB"
                +"-----END PUBLIC KEY-----";
        //        converter.setVerifierKey(key);
        converter.setVerifier(new RsaVerifier(key));
        return converter;
    }




//    @Bean
//    PasswordEncoder passwordEncoder() {
//        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//    }
}
