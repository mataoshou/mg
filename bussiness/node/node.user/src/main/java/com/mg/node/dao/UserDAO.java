package com.mg.node.dao; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mg.node.db.sql.pojo.MTdUserInfo;
import java.util.List;

import com.mg.node.common.plugin.mybatis.imp.IGeneralMapper;

@Repository
public class UserDAO {
   @Autowired
   private IGeneralMapper<MTdUserInfo> mapper;
   

   
   public MTdUserInfo get(Long id){
      return mapper.getById(id);
   }
   
   public MTdUserInfo edit(MTdUserInfo item){
      return null;
   }
   
   public List<MTdUserInfo> list(){
      return mapper.listByWhere(null,null);
   }
   
   public boolean delete(Long id){
      int count = mapper.deleteById(id);
      if(count>0) { return true; }
      return false;
   }
   
   public MTdUserInfo getByName(String name){
      return mapper.getByParam("user_name",name);
   }

}
