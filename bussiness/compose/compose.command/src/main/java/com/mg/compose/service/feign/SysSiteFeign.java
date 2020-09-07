package com.mg.compose.service.feign; 

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mg.common.pojo.ResultItem;
import com.mg.compose.constant.feign.SysSiteFeignConstant;
import com.mg.compose.pojo.dto.InSysSiteDto;
import com.mg.compose.pojo.dto.OutSysSiteDto;

@FeignClient(name = SysSiteFeignConstant.FEIGN_SERVER_NAME,fallbackFactory = SysSiteFeignFallBackFactory.class)
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
