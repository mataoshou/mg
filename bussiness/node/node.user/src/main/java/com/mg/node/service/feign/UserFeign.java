package com.mg.node.service.feign; 

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mg.common.pojo.ResultItem;
import com.mg.node.constant.feign.UserFeignConstant;
import com.mg.node.pojo.dto.InUserDto;
import com.mg.node.pojo.dto.InUserDto;

@FeignClient(name = UserFeignConstant.FEIGN_SERVER_NAME,fallback = UserFeignFallBack.class)
public interface UserFeign {

   @RequestMapping(UserFeignConstant.FEIGN_GET)
    ResultItem<InUserDto> get(InUserDto item);
   @RequestMapping(UserFeignConstant.FEIGN_EDIT)
    ResultItem<InUserDto> edit(InUserDto item);
   @RequestMapping(UserFeignConstant.FEIGN_LIST)
    ResultItem<InUserDto> list(InUserDto item);
   @RequestMapping(UserFeignConstant.FEIGN_DELETE)
    ResultItem<InUserDto> delete(InUserDto item);

}
