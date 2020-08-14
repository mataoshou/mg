package com.mg.node.service.feign; 

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mg.common.pojo.ResultItem;
import com.mg.node.constant.feign.UserFeignConstant;
import com.mg.node.pojo.dto.InUserDto;
import com.mg.node.pojo.dto.OutUserDto;

@FeignClient(name = UserFeignConstant.FEIGN_SERVER_NAME,fallback = UserFeignFallBack.class)
public interface UserFeign {

   @RequestMapping(UserFeignConstant.FEIGN_GET)
    ResultItem<OutUserDto> get(InUserDto item);
   @RequestMapping(UserFeignConstant.FEIGN_INSERT)
    ResultItem<OutUserDto> insert(InUserDto item);
   @RequestMapping(UserFeignConstant.FEIGN_LIST)
    ResultItem<OutUserDto> list(InUserDto item);
   @RequestMapping(UserFeignConstant.FEIGN_UPDATE)
    ResultItem<OutUserDto> update(InUserDto item);
   @RequestMapping(UserFeignConstant.FEIGN_DELETE)
    ResultItem<OutUserDto> delete(InUserDto item);
   @RequestMapping(UserFeignConstant.FEIGN_GETBYNAME)
    ResultItem<InUserDto> getByName(InUserDto item);



}
