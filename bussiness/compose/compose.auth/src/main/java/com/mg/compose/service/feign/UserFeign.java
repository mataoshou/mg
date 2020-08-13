package com.mg.compose.service.feign; 

import com.mg.compose.pojo.dto.OutSysSiteDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mg.common.pojo.ResultItem;
import com.mg.compose.constant.feign.UserFeignConstant;

@FeignClient(name = UserFeignConstant.FEIGN_SERVER_NAME,fallback = UserFeignFallBack.class)
public interface UserFeign {

   @RequestMapping(UserFeignConstant.FEIGN_GET)
    ResultItem<OutSysSiteDto> get(OutSysSiteDto item);

}
