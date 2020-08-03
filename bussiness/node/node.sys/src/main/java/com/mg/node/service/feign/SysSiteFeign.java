package com.mg.node.service.feign; 

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mg.common.pojo.ResultItem;
import com.mg.node.constant.feign.SysSiteFeignConstant;
import com.mg.node.pojo.dto.InSysSiteDto;
import com.mg.node.pojo.dto.OutSysSiteDto;

@FeignClient(name = SysSiteFeignConstant.FEIGN_SERVER_NAME,fallback = SysSiteFeignFallBack.class)
public interface SysSiteFeign {

   @RequestMapping(SysSiteFeignConstant.FEIGN_GET)
    ResultItem<OutSysSiteDto> get(InSysSiteDto item);
   @RequestMapping(SysSiteFeignConstant.FEIGN_EDIT)
    ResultItem<OutSysSiteDto> edit(InSysSiteDto item);
   @RequestMapping(SysSiteFeignConstant.FEIGN_LIST)
    ResultItem<OutSysSiteDto> list(InSysSiteDto item);
   @RequestMapping(SysSiteFeignConstant.FEIGN_DELETE)
    ResultItem<OutSysSiteDto> delete(InSysSiteDto item);

}
