package com.mg.node.service.feign; 

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import com.mg.common.pojo.ResultItem;
import com.mg.node.common.service.feign.BaseFallBack;
import com.mg.node.constant.feign.ArticleFeignConstant;
import com.mg.node.pojo.dto.InArticleDto;
import com.mg.node.pojo.dto.OutArticleDto;

@Component
@Slf4j
public class ArticleFeignFallBack implements ArticleFeign,BaseFallBack {
   String msg ="";
   public ArticleFeignFallBack(String msg) { this.msg = msg; }
   public ArticleFeignFallBack() { this.msg = "未添加异常提示！！"; }

   
   public ResultItem<OutArticleDto> get(InArticleDto item){
      return fail(ArticleFeignConstant.FEIGN_SERVER_NAME,msg);
   }
   
   public ResultItem<OutArticleDto> edit(InArticleDto item){
      return fail(ArticleFeignConstant.FEIGN_SERVER_NAME,msg);
   }
   
   public ResultItem<OutArticleDto> list(InArticleDto item){
      return fail(ArticleFeignConstant.FEIGN_SERVER_NAME,msg);
   }
   
   public ResultItem<OutArticleDto> delete(InArticleDto item){
      return fail(ArticleFeignConstant.FEIGN_SERVER_NAME,msg);
   }

}
