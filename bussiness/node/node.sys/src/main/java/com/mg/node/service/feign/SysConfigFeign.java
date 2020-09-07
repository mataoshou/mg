package com.mg.node.service.feign; 

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mg.common.pojo.ResultItem;
import com.mg.node.constant.feign.SysConfigFeignConstant;
import com.mg.node.pojo.dto.InSysConfigDto;
import com.mg.node.pojo.dto.OutSysConfigDto;

@FeignClient(name = SysConfigFeignConstant.FEIGN_SERVER_NAME,fallbackFactory = SysConfigFeignFallBackFactory.class)
public interface SysConfigFeign {

   @RequestMapping(SysConfigFeignConstant.FEIGN_GET)
    ResultItem<OutSysConfigDto> get(InSysConfigDto item);
   @RequestMapping(SysConfigFeignConstant.FEIGN_INSERT)
    ResultItem<OutSysConfigDto> insert(InSysConfigDto item);
   @RequestMapping(SysConfigFeignConstant.FEIGN_LIST)
    ResultItem<OutSysConfigDto> list(InSysConfigDto item);
   @RequestMapping(SysConfigFeignConstant.FEIGN_UPDATE)
    ResultItem<OutSysConfigDto> update(InSysConfigDto item);
   @RequestMapping(SysConfigFeignConstant.FEIGN_DELETE)
    ResultItem<OutSysConfigDto> delete(InSysConfigDto item);
   @RequestMapping(SysConfigFeignConstant.FEIGN_GETBYNAME)
    ResultItem<OutSysConfigDto> getByName(InSysConfigDto item);

}
