package com.mg.node.service.feign; 

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mg.common.pojo.ResultItem;
import com.mg.node.constant.feign.SysConfigFeignConstant;
import com.mg.node.pojo.dto.InSysConfigDto;
import com.mg.node.pojo.dto.OutSysConfigDto;

@FeignClient(name = SysConfigFeignConstant.FEIGN_SERVER_NAME,fallback = SysConfigFeignFallBack.class)
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
