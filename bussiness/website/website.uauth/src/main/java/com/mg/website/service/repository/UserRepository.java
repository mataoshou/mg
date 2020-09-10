package com.mg.website.service.repository; 

import org.springframework.stereotype.Service;
import com.mg.website.pojo.dto.OutUserDto;
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

   
   public ResultItem get(OutUserDto item) throws Exception{
      ResultItem result =  feign.get(item);
      return result;
   }
   
   public ResultItem edit(OutUserDto item) throws Exception{
      ResultItem result =  feign.edit(item);
      return result;
   }
   
   public ResultItem list(OutUserDto item) throws Exception{
      ResultItem result =  feign.list(item);
      return result;
   }
   
   public ResultItem delete(OutUserDto item) throws Exception{
      ResultItem result =  feign.delete(item);
      return result;
   }

}
