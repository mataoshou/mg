package com.mg.node.service.feign; 

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mg.common.pojo.ResultItem;
import com.mg.node.constant.feign.ArticleFeignConstant;
import com.mg.node.pojo.dto.InArticleDto;
import com.mg.node.pojo.dto.OutArticleDto;

@FeignClient(name = ArticleFeignConstant.FEIGN_SERVER_NAME,fallbackFactory = ArticleFeignFallBackFactory.class)
public interface ArticleFeign {

   @RequestMapping(ArticleFeignConstant.FEIGN_GET)
    ResultItem<OutArticleDto> get(InArticleDto item);
   @RequestMapping(ArticleFeignConstant.FEIGN_EDIT)
    ResultItem<OutArticleDto> edit(InArticleDto item);
   @RequestMapping(ArticleFeignConstant.FEIGN_LIST)
    ResultItem<OutArticleDto> list(InArticleDto item);
   @RequestMapping(ArticleFeignConstant.FEIGN_DELETE)
    ResultItem<OutArticleDto> delete(InArticleDto item);

}
