package com.mg.website.service.repository; 

import com.mg.website.service.feign.AuthFeign;
import org.springframework.stereotype.Service;
import com.mg.website.pojo.dto.InUserDto;
import lombok.extern.slf4j.Slf4j;
import com.mg.website.pojo.dto.InUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import com.mg.common.pojo.ResultItem;
import com.mg.website.service.feign.UserFeign;
import java.util.List;

@Service
@Slf4j
public class UserRepository {
   @Autowired
   UserFeign feign;

   @Autowired
   AuthFeign authFeign;

   
   public ResultItem get(InUserDto item) throws Exception{

      Object result1 = authFeign.getToken("website","123456","password",
              "matao","123456");

      log.info(result1.toString());

      ResultItem result =  feign.get(item);
      return result;
   }
   
   public ResultItem edit(InUserDto item) throws Exception{
      ResultItem result =  feign.edit(item);
      return result;
   }
   
   public ResultItem list(InUserDto item) throws Exception{
      ResultItem result =  feign.list(item);
      return result;
   }
   
   public ResultItem delete(InUserDto item) throws Exception{
      ResultItem result =  feign.delete(item);
      return result;
   }

}
