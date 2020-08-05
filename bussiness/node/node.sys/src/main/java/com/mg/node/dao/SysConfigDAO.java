package com.mg.node.dao; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mg.node.db.sql.pojo.MTdSysConfig;
import java.util.List;
import com.mg.common.util.GuidUtil;
import com.mg.node.common.frame.mgmybatis.imp.IGeneralMapper;

@Repository
public class SysConfigDAO extends SuperDao<MTdSysConfig,Long>{
   @Autowired
   private IGeneralMapper<MTdSysConfig> mapper;
   
   public MTdSysConfig getById(Long id){
      return mapper.getById(id);
   }
   
   public MTdSysConfig edit(MTdSysConfig item) throws Exception {
      long no = mapper.insertItem(item);
      return null;
   }
   
   public List<MTdSysConfig> list(){
      return mapper.listByWhere(null,null);
   }
   
   public boolean delete(Long id){
      int count = mapper.deleteById(id);
      if(count>0) { return true; }
      return false;
   }

}
