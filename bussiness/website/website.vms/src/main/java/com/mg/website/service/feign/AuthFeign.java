package com.mg.website.service.feign; 

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mg.common.pojo.ResultItem;
import com.mg.website.constant.feign.AuthFeignConstant;
import com.mg.website.pojo.dto.InUserDto;
import com.mg.website.pojo.dto.InUserDto;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = AuthFeignConstant.FEIGN_SERVER_NAME,fallback = AuthFeignFallBack.class)
public interface AuthFeign {

   @RequestMapping(AuthFeignConstant.FEIGN_TOKEN)
   Object getToken(@RequestParam("client_id") String client_id,
                               @RequestParam("client_secret") String client_secret,
                               @RequestParam("grant_type") String grant_type,
                               @RequestParam("username") String username,
                               @RequestParam("password") String password);

}
