package com.mg.node.action; 

import com.mg.node.common.plugin.param.annotation.ParamsCheck;
import com.mg.node.pojo.dto.InArticleDto;
import com.mg.node.pojo.dto.OutArticleDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.mg.node.service.repository.ArticleRepository;
import com.mg.node.constant.action.ArticleControllerConstant;
import org.springframework.web.bind.annotation.RequestBody;
import com.mg.common.pojo.ResultItem;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
public class ArticleController {
   @Autowired
   ArticleRepository repository;

   @ParamsCheck("id:noNull:id不能为空")
   @RequestMapping(ArticleControllerConstant.ACTION_GET)
   public ResultItem get(@RequestBody InArticleDto dtoData) throws Exception{
      return repository.get(dtoData);
   }
   @RequestMapping(ArticleControllerConstant.ACTION_EDIT)
   public ResultItem edit(@RequestBody InArticleDto dtoData) throws Exception{
      return repository.edit(dtoData);
   }
   @RequestMapping(ArticleControllerConstant.ACTION_LIST)
   public ResultItem list(@RequestBody InArticleDto dtoData) throws Exception{
      return repository.list(dtoData);
   }
   @RequestMapping(ArticleControllerConstant.ACTION_DELETE)
   public ResultItem delete(@RequestBody InArticleDto dtoData) throws Exception{
      return repository.delete(dtoData);
   }

}
