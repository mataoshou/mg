package com.mg.node.service.repository; 

import com.mg.node.db.sql.pojo.MTdArticleInfo;
import org.springframework.stereotype.Service;
import com.mg.node.pojo.dto.OutArticleDto;
import com.mg.node.pojo.dto.InArticleDto;
import lombok.extern.slf4j.Slf4j;
import com.mg.node.db.sql.pojo.MTdArticleDetailInfo;
import org.springframework.beans.factory.annotation.Autowired;
import com.mg.common.pojo.ResultItem;
import com.mg.node.common.mapper.GeneralMapper;
import com.mg.node.dao.ArticleDAO;
import com.mg.node.service.feign.ArticleFeign;
import java.util.List;

@Service
@Slf4j
public class ArticleRepository {
   @Autowired
   ArticleDAO dao;
   @Autowired
   GeneralMapper mapper;

   
   public ResultItem get(InArticleDto item) throws Exception{
      MTdArticleInfo pojo = dao.get(item.getId());
      MTdArticleDetailInfo detailInfo = dao.getDetail(item.getId());
      OutArticleDto dto = mapper.convert(pojo,OutArticleDto.class);
      mapper.copyConvertor(detailInfo,dto);
      ResultItem result =  new ResultItem<OutArticleDto>(dto);
      return result;
   }
   
   public ResultItem edit(InArticleDto item) throws Exception{
      MTdArticleInfo pojo = mapper.convert(item,MTdArticleInfo.class);
      MTdArticleDetailInfo detailInfo = mapper.convert(item,MTdArticleDetailInfo.class);
      ResultItem result = new ResultItem<OutArticleDto>(
              mapper.convert(dao.edit(pojo,detailInfo),OutArticleDto.class));



      return result;
   }
   
   public ResultItem list(InArticleDto item) throws Exception{
      List<MTdArticleInfo> list = dao.list();
      ResultItem result =  new ResultItem<OutArticleDto>(mapper.convert(list,OutArticleDto.class));
      return result;
   }
   
   public ResultItem delete(InArticleDto item) throws Exception{
      dao.delete(item.getId());
      ResultItem result = new ResultItem();
      return result;
   }

}
