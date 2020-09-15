package com.mg.compose.service.repository; 

import org.springframework.stereotype.Service;
import com.mg.compose.pojo.dto.InSite;
import lombok.extern.slf4j.Slf4j;
import com.mg.compose.pojo.dto.OutSite;
import org.springframework.beans.factory.annotation.Autowired;
import com.mg.common.pojo.ResultItem;
import com.mg.compose.service.feign.SiteFeign;
import java.util.List;

@Service
@Slf4j
public class SiteRepository {
   @Autowired
   SiteFeign feign;

   
   public ResultItem get(InSite item) throws Exception{
      ResultItem result =  feign.get(item);
      return result;
   }
   
   public ResultItem edit(InSite item) throws Exception{
      ResultItem result =  feign.edit(item);
      return result;
   }
   
   public ResultItem list(InSite item) throws Exception{
      ResultItem result =  feign.list(item);
      return result;
   }
   
   public ResultItem delete(InSite item) throws Exception{
      ResultItem result =  feign.delete(item);
      return result;
   }

}
