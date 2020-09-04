package com.mg.website.service.feign; 

import com.mg.website.pojo.dto.OutUserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mg.common.pojo.ResultItem;
import com.mg.website.constant.feign.FreeFeignConstant;
import com.mg.website.pojo.dto.InUserDto;
import com.mg.website.pojo.dto.InUserDto;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = FreeFeignConstant.FEIGN_SERVER_NAME,fallbackFactory = FreeFeignFallbackFactory.class)
public interface FreeFeign {

   @RequestMapping(value =FreeFeignConstant.FEIGN_LOGIN,method = RequestMethod.GET)
   ResultItem<OutUserDto> login(@RequestParam("client_id") String client_id,
                                 @RequestParam("client_secret")String client_secret,
                                 @RequestParam("grant_type")String grant_type,
                                 @RequestParam("username")String username,
                                 @RequestParam("password")String password);

    @RequestMapping(value =FreeFeignConstant.FEIGN_LOGIN,method = RequestMethod.POST)
    ResultItem<OutUserDto> login( @RequestBody InUserDto dto);

}
