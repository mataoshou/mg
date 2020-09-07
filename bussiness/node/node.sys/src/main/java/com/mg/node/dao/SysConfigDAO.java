package com.mg.node.dao; 

import com.mg.node.db.sql.pojo.MTdSysSite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mg.node.db.sql.pojo.MTdSysConfig;
import java.util.List;
import com.mg.common.util.GuidUtil;
import com.mg.node.common.frame.mgmybatis.imp.IGeneralMapper;

@Repository
public class SysConfigDAO {
   @Autowired
   private IGeneralMapper<MTdSysConfig> mapper;
   

   
   public MTdSysConfig get(Long id){
      return mapper.getById(id);
   }
   
   public MTdSysConfig insert(MTdSysConfig item){
      return null;
   }
   
   public List<MTdSysConfig> list(){
      return mapper.listByWhere(null,null);
   }
   
   public MTdSysConfig update(MTdSysConfig item){
      return null;
   }
   
   public boolean delete(Long id){
      int count = mapper.deleteById(id);
      if(count>0) { return true; }
      return false;
   }
   
   public MTdSysConfig getByName(String name){
      MTdSysConfig config = mapper.getBySingleParam("configName",name);
      return config;
   }

}
