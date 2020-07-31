package com.mg.website.service.feign; 

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import com.mg.common.pojo.ResultItem;
import com.mg.website.common.service.feign.BaseFallBack;
import com.mg.website.constant.feign.AuthFeignConstant;
import com.mg.website.pojo.dto.InUserDto;
import com.mg.website.pojo.dto.InUserDto;

@Component
@Slf4j
public class AuthFeignFallBack implements AuthFeign,BaseFallBack {
   public Object getToken(String client_id,String client_secret,String grant_type,String username,String password)
   {
      return fail(AuthFeignConstant.FEIGN_SERVER_NAME);
   }
}
