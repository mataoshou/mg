package com.mg.compose.service.feign; 

import com.mg.compose.pojo.dto.InSysSiteDto;
import com.mg.compose.pojo.dto.OutSysSiteDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mg.common.pojo.ResultItem;
import com.mg.compose.constant.feign.SysFeignConstant;

@FeignClient(name = SysFeignConstant.FEIGN_SERVER_NAME,fallback = SysFeignFallBack.class)
public interface SysFeign {

   @RequestMapping(SysFeignConstant.FEIGN_GET)
    ResultItem<OutSysSiteDto> getByName(InSysSiteDto item);

}
