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

   @RequestMapping(SysSiteFeignConstant.FEIGN_GETBYNAME)
    ResultItem<OutSysSiteDto> getByName(InSysSiteDto item);

}
