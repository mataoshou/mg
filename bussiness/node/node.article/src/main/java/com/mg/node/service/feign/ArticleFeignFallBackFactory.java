package com.mg.node.service.feign; 

import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;
import feign.hystrix.FallbackFactory;

@Slf4j
@Component
public class ArticleFeignFallBackFactory implements FallbackFactory<ArticleFeign> {

   @Override
   public ArticleFeign create(Throwable cause){
      log.info(cause.getMessage());
      cause.printStackTrace();
      return new ArticleFeignFallBack(cause.getMessage());
   }

}
