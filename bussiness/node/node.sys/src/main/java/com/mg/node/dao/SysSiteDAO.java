package com.mg.node.dao; 

import com.esotericsoftware.minlog.Log;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mg.node.db.sql.pojo.MTdSysSite;
import java.util.List;
import java.util.Map;

import com.mg.node.common.plugin.mybatis.imp.IGeneralMapper;

@Repository
public class SysSiteDAO {
   @Autowired
   private IGeneralMapper<MTdSysSite> mapper;

   public MTdSysSite get(Long id){
      return mapper.getById(id);
   }
   
   public MTdSysSite edit(MTdSysSite item) throws Exception {
      long no = mapper.insertItem(item);
      item.setPassword("msssd"+ System.currentTimeMillis());
      no = mapper.updateItem(item);
      return item;
   }
   
   public List<MTdSysSite> list(){
      PageHelper.startPage(1, 20);
      Page<MTdSysSite> userList= mapper.listByPage(null,null);
      userList.getPageNum();
//      return userList;
      return mapper.listByWhere(null,null);
   }
   
   public boolean delete(Long id){
      int count = mapper.deleteById(id);
      if(count>0) { return true; }
      return false;
   }

   public MTdSysSite getByName(String name)
   {
      MTdSysSite site = mapper.getBySingleParam("siteName",name);
      return site;
   }

   public void getMap()
   {
      Map map = mapper.getMap("select * from m_td_sys_site where id=2");
//      Object  maps = mapper.listMap("select * from m_td_sys_site");
      Log.info(map.size()+"");
   }
}
