package com.mg.website.service.repository; 

import org.springframework.stereotype.Service;
import com.mg.website.pojo.dto.InUserDto;
import lombok.extern.slf4j.Slf4j;
import com.mg.website.pojo.dto.InUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import com.mg.common.pojo.ResultItem;
import com.mg.website.service.feign.FreeFeign;
import java.util.List;

@Service
@Slf4j
public class FreeRepository {
   @Autowired
   FreeFeign feign;

   
   public ResultItem login(InUserDto item) throws Exception{
      ResultItem result =  feign.login(item);
      return result;
   }

}
