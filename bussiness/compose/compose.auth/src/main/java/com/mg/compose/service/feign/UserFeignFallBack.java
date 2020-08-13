package com.mg.compose.service.feign; 

import com.mg.compose.pojo.dto.OutSysSiteDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import com.mg.common.pojo.ResultItem;
import com.mg.compose.common.service.feign.BaseFallBack;
import com.mg.compose.constant.feign.UserFeignConstant;

@Component
@Slf4j
public class UserFeignFallBack implements UserFeign,BaseFallBack {

   
   public ResultItem<OutSysSiteDto> get(OutSysSiteDto item){
      return fail(UserFeignConstant.FEIGN_SERVER_NAME);
   }

}
