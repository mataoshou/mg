package com.mg.compose.service.feign; 

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import com.mg.common.pojo.ResultItem;
import com.mg.compose.common.service.feign.BaseFallBack;
import com.mg.compose.constant.feign.SysConfigFeignConstant;
import com.mg.compose.pojo.dto.InSysConfigDto;
import com.mg.compose.pojo.dto.OutSysConfigDto;

@Component
@Slf4j
public class SysConfigFeignFallBack implements SysConfigFeign,BaseFallBack {

   
   public ResultItem<OutSysConfigDto> get(InSysConfigDto item){
      return fail(SysConfigFeignConstant.FEIGN_SERVER_NAME);
   }
   
   public ResultItem<OutSysConfigDto> edit(InSysConfigDto item){
      return fail(SysConfigFeignConstant.FEIGN_SERVER_NAME);
   }
   
   public ResultItem<OutSysConfigDto> list(InSysConfigDto item){
      return fail(SysConfigFeignConstant.FEIGN_SERVER_NAME);
   }
   
   public ResultItem<OutSysConfigDto> delete(InSysConfigDto item){
      return fail(SysConfigFeignConstant.FEIGN_SERVER_NAME);
   }

}
