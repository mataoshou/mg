package com.mg.node.dao; 

import com.mg.node.common.plugin.mybatis.imp.IGeneralMapper;
import com.mg.node.db.sql.pojo.MTdArticleDetailInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mg.node.db.sql.pojo.MTdArticleInfo;

import java.util.Date;
import java.util.List;
import com.mg.common.util.GuidUtil;

@Repository
public class ArticleDAO {

   @Autowired
   private IGeneralMapper<MTdArticleInfo> mapper;

   @Autowired
   private IGeneralMapper<MTdArticleDetailInfo> detailMapper;

   public MTdArticleInfo get(Long id){
      return mapper.getById(id);
   }

   public MTdArticleDetailInfo getDetail(Long id){
      return detailMapper.getById(id);
   }
   
   public MTdArticleInfo edit(MTdArticleInfo item,MTdArticleDetailInfo detail){
      if(item.getId()==null||item.getId().equals(0L))
      {
         item.setId(null);
         item.setTimeCreated(new Date());
         item.setShowIndex(0);
         item.setTimeModefied(new Date());
         mapper.insertItem(item);
         detail.setId(item.getId());
         detailMapper.insertItem(detail);
      }
      else{
         item.setTimeModefied(new Date());
         mapper.updateItem(item);
         detailMapper.updateItem(detail);
      }
      return item;
   }
   
   public List<MTdArticleInfo> list(){
      return mapper.listByWhere(null,null);
   }
   
   public boolean delete(Long id){
      int count = mapper.deleteById(id);
      if(count>0) { return true; }
      return false;
   }

}
