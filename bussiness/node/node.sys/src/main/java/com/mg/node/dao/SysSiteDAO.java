package com.mg.node.dao; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mg.node.db.sql.pojo.MTdSysSite;
import java.util.List;
import com.mg.common.util.GuidUtil;
import com.mg.node.common.frame.mgmybatis.imp.IGeneralMapper;

@Repository
public class SysSiteDAO {
   @Autowired
   private IGeneralMapper<MTdSysSite> mapper;
   

   
   public MTdSysSite get(Long id){
      return mapper.getById(id);
   }
   
   public MTdSysSite edit(MTdSysSite item){
      return null;
   }
   
   public List<MTdSysSite> list(){
      return mapper.listByWhere(null,null);
   }
   
   public boolean delete(Long id){
      int count = mapper.deleteById(id);
      if(count>0) { return true; }
      return false;
   }

}
