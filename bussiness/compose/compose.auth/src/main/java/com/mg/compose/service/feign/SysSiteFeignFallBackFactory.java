package com.mg.compose.service.feign; 

import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;
import feign.hystrix.FallbackFactory;

@Slf4j
@Component
public class SysSiteFeignFallBackFactory implements FallbackFactory<SysSiteFeign> {

   @Override
   public SysSiteFeign create(Throwable cause){
      log.info(cause.getMessage());
      cause.printStackTrace();
      return new SysSiteFeignFallBack(cause.getMessage());
   }

}
