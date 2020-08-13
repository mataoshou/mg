package com.mg.compose.service.repository; 

import org.springframework.stereotype.Service;
import com.mg.compose.pojo.dto.InSysSiteDto;
import lombok.extern.slf4j.Slf4j;
import com.mg.compose.pojo.dto.OutSysSiteDto;
import org.springframework.beans.factory.annotation.Autowired;
import com.mg.common.pojo.ResultItem;
import com.mg.compose.service.feign.SysSiteFeign;
import java.util.List;

@Service
@Slf4j
public class SysSiteRepository {
   @Autowired
   SysSiteFeign feign;

   
   public ResultItem get(InSysSiteDto item) throws Exception{
      ResultItem result =  feign.get(item);
      return result;
   }
   
   public ResultItem edit(InSysSiteDto item) throws Exception{
      ResultItem result =  feign.edit(item);
      return result;
   }
   
   public ResultItem list(InSysSiteDto item) throws Exception{
      ResultItem result =  feign.list(item);
      return result;
   }
   
   public ResultItem delete(InSysSiteDto item) throws Exception{
      ResultItem result =  feign.delete(item);
      return result;
   }

}
