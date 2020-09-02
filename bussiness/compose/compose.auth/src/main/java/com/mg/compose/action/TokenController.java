package com.mg.compose.action; 

import com.mg.compose.pojo.dto.InSysConfigDto;
import com.mg.compose.pojo.dto.InSysConfigDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.mg.compose.service.repository.TokenRepository;
import com.mg.compose.constant.action.TokenControllerConstant;
import org.springframework.web.bind.annotation.RequestBody;
import com.mg.common.pojo.ResultItem;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
public class TokenController {
   @Autowired
   TokenRepository repository;

   @RequestMapping(TokenControllerConstant.ACTION_LOGIN)
   public ResultItem login(@RequestBody InSysConfigDto dto) throws Exception{

         MultiValueMap<String,Object> paramsMap=new LinkedMultiValueMap<>();

         RestTemplate restTemplate=new RestTemplate();
         restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor(map.get("client_id").toString(),map.get("client_secret").toString()));
         OAuth2AccessToken token=restTemplate.postForObject("http://localhost:8080/oauth/token",paramsMap,OAuth2AccessToken.class);
         return new ResultItem(token);

      }

}
