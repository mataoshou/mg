package com.mg.website.service.feign; 

import com.mg.website.pojo.dto.OutUserDto;
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

   
   public ResultItem<OutUserDto> login(String client_id, String client_secret, String grant_type,
                                           String username, String password){
      return fail(FreeFeignConstant.FEIGN_SERVER_NAME,"");
   }

   @Override
   public ResultItem<OutUserDto> login(InUserDto dto) {
      return fail(FreeFeignConstant.FEIGN_SERVER_NAME,"");
   }

}
