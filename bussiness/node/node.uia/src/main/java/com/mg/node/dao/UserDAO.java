package com.mg.node.dao; 

import com.mg.common.util.StringUtil;
import com.mg.node.db.sql.pojo.MTcOperateGroupInfo;
import com.mg.node.service.cache.UserCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mg.node.db.sql.pojo.MTdUserInfo;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.mg.common.util.GuidUtil;
import com.mg.node.common.plugin.mybatis.imp.IGeneralMapper;

@Repository
public class UserDAO {
   @Autowired
   private IGeneralMapper<MTdUserInfo> mapper;

   @Autowired
   private UserCache cache;

   public MTdUserInfo get(String id) throws Exception {
      return cache.get(id);
   }
   
   public MTdUserInfo edit(MTdUserInfo item) throws Exception {
      return cache.update(item);
   }
   
   public List<MTdUserInfo> list(){
      return mapper.listByWhere(null,null);
   }
   
   public void delete(String id) throws Exception {
      cache.delete(id);
   }

}
