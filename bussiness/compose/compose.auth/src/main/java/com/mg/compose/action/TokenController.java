package com.mg.compose.action;

import com.mg.common.pojo.ResultItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/oauth")
public class TokenController {
    @Autowired
    private TokenEndpoint tokenEndpoint;

    /**
     * Oauth2登录认证
     */
    @RequestMapping(value = "/token", method = {RequestMethod.POST,RequestMethod.GET})
    public ResultItem postAccessToken(Principal principal, @RequestParam Map<String, String> parameters) throws HttpRequestMethodNotSupportedException {
        try {
            OAuth2AccessToken oAuth2AccessToken = tokenEndpoint.postAccessToken(principal, parameters).getBody();

            ResultItem<OAuth2AccessToken> item = new ResultItem(oAuth2AccessToken);
            OAuth2AccessToken token = item.toItem();
            return item;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return new ResultItem(401,"FAIL");
    }

}
