package com.mg.website.service.feign; 

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import com.mg.common.pojo.ResultItem;
import com.mg.website.common.service.feign.BaseFallBack;
import com.mg.website.constant.feign.FreeFeignConstant;
import com.mg.website.pojo.dto.InUserDto;
import com.mg.website.pojo.dto.InUserDto;

@Component
@Slf4j
public class FreeFeignFallBack implements FreeFeign,BaseFallBack {

   
   public ResultItem<InUserDto> login(InUserDto item){
      return fail(FreeFeignConstant.FEIGN_SERVER_NAME);
   }

}
