package com.mg.compose.service.feign; 

import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;
import feign.hystrix.FallbackFactory;

@Slf4j
@Component
public class SiteFeignFallBackFactory implements FallbackFactory<SiteFeign> {

   @Override
   public SiteFeign create(Throwable cause){
      log.info(cause.getMessage());
      cause.printStackTrace();
      return new SiteFeignFallBack(cause.getMessage());
   }

}
