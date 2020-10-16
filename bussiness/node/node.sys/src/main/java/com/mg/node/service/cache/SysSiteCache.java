package com.mg.node.service.cache; 

import com.mg.node.common.service.cache.CacheStore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.mg.node.db.sql.pojo.MTdSysSite;
import com.mg.node.common.service.cache.IBaseCache;

@Service
@Slf4j
public class SysSiteCache extends IBaseCache<MTdSysSite,Long>  {

   public SysSiteCache(){new CacheStore().add(MTdSysSite.class,this);}

   @Override
   protected MTdSysSite getPojo(Long id){
      return null;
   }
   @Override
   protected MTdSysSite updatePojo(MTdSysSite pojo){
      return null;
   }
   @Override
   protected MTdSysSite deletePojo(Long id){
      return null;
   }
   @Override
   public Long getId(MTdSysSite pojo){
      return pojo.getSiteId();
   }

}
