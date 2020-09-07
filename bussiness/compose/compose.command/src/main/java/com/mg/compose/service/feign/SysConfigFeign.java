package com.mg.compose.service.feign; 

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mg.common.pojo.ResultItem;
import com.mg.compose.constant.feign.SysConfigFeignConstant;
import com.mg.compose.pojo.dto.InSysConfigDto;
import com.mg.compose.pojo.dto.OutSysConfigDto;

@FeignClient(name = SysConfigFeignConstant.FEIGN_SERVER_NAME,fallbackFactory = SysConfigFeignFallBackFactory.class)
public interface SysConfigFeign {

   @RequestMapping(SysConfigFeignConstant.FEIGN_GET)
    ResultItem<OutSysConfigDto> get(InSysConfigDto item);
   @RequestMapping(SysConfigFeignConstant.FEIGN_EDIT)
    ResultItem<OutSysConfigDto> edit(InSysConfigDto item);
   @RequestMapping(SysConfigFeignConstant.FEIGN_LIST)
    ResultItem<OutSysConfigDto> list(InSysConfigDto item);
   @RequestMapping(SysConfigFeignConstant.FEIGN_DELETE)
    ResultItem<OutSysConfigDto> delete(InSysConfigDto item);

}
