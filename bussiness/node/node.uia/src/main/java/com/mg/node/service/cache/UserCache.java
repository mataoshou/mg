package com.mg.node.service.cache; 

import com.mg.common.util.GuidUtil;
import com.mg.common.util.StringUtil;
import com.mg.node.common.plugin.mybatis.imp.IGeneralMapper;
import com.mg.node.common.service.cache.CacheStore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import com.mg.node.db.sql.pojo.MTdUserInfo;
import com.mg.node.pojo.dto.in.InDepartmentDto;
import com.mg.node.common.service.cache.IBaseCache;
import org.springframework.beans.factory.annotation.Autowired;

@Service
@Slf4j
public class UserCache extends IBaseCache<MTdUserInfo,String,String>  {

   public UserCache(){
      setMaster();
      CacheStore.add(MTdUserInfo.class,this);
      setCacheDecorate(UserCache.class.getSimpleName(),MTdUserInfo.class.getSimpleName(),MTdUserInfo.class);
   }

   @Autowired
   IGeneralMapper<MTdUserInfo> mapper;

   @Override
   protected MTdUserInfo getByDB(String id) {
      MTdUserInfo info = mapper.getByStrId(id);
      return info;
   }

   @Override
   protected MTdUserInfo updateDB(MTdUserInfo pojo) {
      if(StringUtil.isEmpty(pojo.getUserId()))
      {
         pojo.setUserId(GuidUtil.gen());
         pojo.setTimeCreated(new Date());
         pojo.setTimeModify(new Date());
         pojo.setCreateId("0");
         pojo.setModifiesId("0");
         mapper.insertItem(pojo);
      }
      else {
         mapper.updateItem(pojo);
      }
      try {
         pojo =get(pojo.getUserId());
      } catch (Exception e) {
         e.printStackTrace();
      }
      return pojo;
   }

   @Override
   protected void deleteDB(String id) {
      mapper.deleteByStrId(id);
   }

   @Override
   public String getId(MTdUserInfo pojo){
      return pojo.getUserId();
   }

   @Override
   public String getQueryParam(MTdUserInfo pojo) {
      return pojo.getUserId();
   }

   @Override
   public MTdUserInfo buildQuery(String id) {
      MTdUserInfo mTdUserInfo = new MTdUserInfo();
      mTdUserInfo.setUserId(id);
      return mTdUserInfo;
   }

}
