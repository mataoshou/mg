package com.mg.website.service.feign; 

import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;
import feign.hystrix.FallbackFactory;

@Slf4j
@Component
public class OauthFeignFallBackFactory implements FallbackFactory<OauthFeign> {

   @Override
   public OauthFeign create(Throwable cause){
      log.info(cause.getMessage());
      cause.printStackTrace();
      return new OauthFeignFallBack(cause.getMessage());
   }

}
