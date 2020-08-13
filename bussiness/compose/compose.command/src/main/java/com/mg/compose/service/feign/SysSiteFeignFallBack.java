package com.mg.compose.service.feign; 

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import com.mg.common.pojo.ResultItem;
import com.mg.compose.common.service.feign.BaseFallBack;
import com.mg.compose.constant.feign.SysSiteFeignConstant;
import com.mg.compose.pojo.dto.InSysSiteDto;
import com.mg.compose.pojo.dto.OutSysSiteDto;

@Component
@Slf4j
public class SysSiteFeignFallBack implements SysSiteFeign,BaseFallBack {

   
   public ResultItem<OutSysSiteDto> get(InSysSiteDto item){
      return fail(SysSiteFeignConstant.FEIGN_SERVER_NAME);
   }
   
   public ResultItem<OutSysSiteDto> edit(InSysSiteDto item){
      return fail(SysSiteFeignConstant.FEIGN_SERVER_NAME);
   }
   
   public ResultItem<OutSysSiteDto> list(InSysSiteDto item){
      return fail(SysSiteFeignConstant.FEIGN_SERVER_NAME);
   }
   
   public ResultItem<OutSysSiteDto> delete(InSysSiteDto item){
      return fail(SysSiteFeignConstant.FEIGN_SERVER_NAME);
   }

}
