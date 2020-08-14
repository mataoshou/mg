package com.mg.website.service.feign; 

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mg.common.pojo.ResultItem;
import com.mg.website.constant.feign.FreeFeignConstant;
import com.mg.website.pojo.dto.InUserDto;
import com.mg.website.pojo.dto.InUserDto;

@FeignClient(name = FreeFeignConstant.FEIGN_SERVER_NAME,fallback = FreeFeignFallBack.class)
public interface FreeFeign {

   @RequestMapping(FreeFeignConstant.FEIGN_LOGIN)
    ResultItem<InUserDto> login(InUserDto item);

}
