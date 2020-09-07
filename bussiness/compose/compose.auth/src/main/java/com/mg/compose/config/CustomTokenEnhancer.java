package com.mg.compose.config;

import com.mg.compose.pojo.bo.UserBo;
import com.mg.compose.pojo.dto.OutUserDto;
import com.mg.compose.service.feign.UserFeign;
import com.mg.compose.service.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class CustomTokenEnhancer implements TokenEnhancer {

    @Autowired
    UserRepository repository;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {

        try {
            User user = (User) oAuth2Authentication.getPrincipal();
            UserBo dto = repository.getByName(user.getUsername());
            Map<String, Object> additionalInfo = new HashMap<>();
            additionalInfo.put("userId", dto.getId());
            ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(
                    additionalInfo);
            return oAuth2AccessToken;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return oAuth2AccessToken;
    }
}
