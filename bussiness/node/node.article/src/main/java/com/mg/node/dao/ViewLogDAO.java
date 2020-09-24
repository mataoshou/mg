package com.mg.node.dao; 

import com.mg.node.common.util.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mg.node.db.sql.pojo.MTdViewLog;

import java.util.Date;
import java.util.List;
import com.mg.common.util.GuidUtil;
import com.mg.node.common.plugin.mybatis.imp.IGeneralMapper;

@Repository
public class ViewLogDAO {
   @Autowired
   private IGeneralMapper<MTdViewLog> mapper;

   @Autowired
   HttpUtil httpUtil;
   
   public MTdViewLog get(Long id){
      return mapper.getById(id);
   }
   
   public MTdViewLog edit(MTdViewLog item){
      if(item.getId()==null||item.getId()==0) {
         mapper.insertItem(item);
      }
      else {
         mapper.updateItem(item);
      }
      return item;
   }

   public MTdViewLog addLog(String msg){
      MTdViewLog viewLog = new MTdViewLog();
      viewLog.setVip(httpUtil.getRequest().getRemoteHost());
      viewLog.setVsrc(httpUtil.getRequest().getRequestURI());
      viewLog.setTimeCreated(new Date());
      viewLog.setMsg(msg);
      mapper.insertItem(viewLog);
      return viewLog;
   }
   
   public List<MTdViewLog> list(){
      return mapper.listByWhere(null,null);
   }
   
   public boolean delete(Long id){
      int count = mapper.deleteById(id);
      if(count>0) { return true; }
      return false;
   }

}
