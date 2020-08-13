package com.mg.compose.service.feign; 

import com.mg.compose.pojo.dto.InSysSiteDto;
import com.mg.compose.pojo.dto.OutSysSiteDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import com.mg.common.pojo.ResultItem;
import com.mg.compose.common.service.feign.BaseFallBack;
import com.mg.compose.constant.feign.SysFeignConstant;

@Component
@Slf4j
public class SysFeignFallBack implements SysFeign,BaseFallBack {

   public ResultItem<OutSysSiteDto> getByName(InSysSiteDto item){
      return fail(SysFeignConstant.FEIGN_SERVER_NAME);
   }

}
