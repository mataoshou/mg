package com.mg.node.service.feign; 

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mg.common.pojo.ResultItem;
import com.mg.node.constant.feign.SysSiteFeignConstant;
import com.mg.node.pojo.dto.InSysSiteDto;
import com.mg.node.pojo.dto.OutSysSiteDto;

@FeignClient(name = SysSiteFeignConstant.FEIGN_SERVER_NAME,fallbackFactory = SysSiteFeignFallBackFactory.class)
public interface SysSiteFeign {

   @RequestMapping(SysSiteFeignConstant.FEIGN_GET)
    ResultItem<OutSysSiteDto> get(InSysSiteDto item);
   @RequestMapping(SysSiteFeignConstant.FEIGN_INSERT)
    ResultItem<OutSysSiteDto> insert(InSysSiteDto item);
   @RequestMapping(SysSiteFeignConstant.FEIGN_LIST)
    ResultItem<OutSysSiteDto> list(InSysSiteDto item);
   @RequestMapping(SysSiteFeignConstant.FEIGN_UPDATE)
    ResultItem<OutSysSiteDto> update(InSysSiteDto item);
   @RequestMapping(SysSiteFeignConstant.FEIGN_DELETE)
    ResultItem<OutSysSiteDto> delete(InSysSiteDto item);
   @RequestMapping(SysSiteFeignConstant.FEIGN_GETBYNAME)
    ResultItem<OutSysSiteDto> getByName(InSysSiteDto item);

}
