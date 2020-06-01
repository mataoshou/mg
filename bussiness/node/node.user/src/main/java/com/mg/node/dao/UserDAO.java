package com.mg.node.dao; 

import com.mg.node.mapper.GeneralMapper;
import com.mg.node.pojo.po.UserPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mg.node.db.sql.merge.IRmtUserInfoMapper;
import com.mg.node.db.sql.pojo.RmtUserInfo;
import java.util.List;
import com.mg.common.util.GuidUtil;

@Repository
public class UserDAO {
   @Autowired
   private IRmtUserInfoMapper mapper;
   
   public RmtUserInfo get(String id){
      return mapper.selectByPrimaryKey(id);
   }
   
   public RmtUserInfo edit(RmtUserInfo item){
      return null;
   }
   
   public List<RmtUserInfo> list(){
      return mapper.list(null,null);
   }
   
   public boolean delete(String id){
      int count = mapper.deleteByPrimaryKey(id);
      if(count>0) { return true; }
      return false;
   }

}
