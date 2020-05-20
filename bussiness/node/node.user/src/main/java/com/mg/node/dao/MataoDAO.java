package com.mg.node.dao; 

import com.mg.common.util.GuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mg.node.db.sql.merge.IRmtActiorInfoMapper;
import com.mg.node.db.sql.pojo.RmtActiorInfo;
import java.util.List;

@Repository
public class MataoDAO {
   @Autowired
   private IRmtActiorInfoMapper mapper;
   
    RmtActiorInfo get(String id){
      return mapper.selectByPrimaryKey(id);
   }
   
    RmtActiorInfo edit(RmtActiorInfo item){
      return null;
   }
   
    List<RmtActiorInfo> list(){
      return mapper.list(null,null);
   }
   
    boolean delete(String id){
      int count = mapper.deleteByPrimaryKey(id);
      if(count>0) { return true; }
      return false;
   }

}
