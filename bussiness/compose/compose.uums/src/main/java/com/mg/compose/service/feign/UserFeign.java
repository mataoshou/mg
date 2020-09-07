package com.mg.compose.service.feign; 

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mg.common.pojo.ResultItem;
import com.mg.compose.constant.feign.UserFeignConstant;
import com.mg.compose.pojo.dto.InUserDto;
import com.mg.compose.pojo.dto.OutUserDto;

@FeignClient(name = UserFeignConstant.FEIGN_SERVER_NAME,fallbackFactory = UserFeignFallBackFactory.class)
public interface UserFeign {

   @RequestMapping(UserFeignConstant.FEIGN_GET)
    ResultItem<OutUserDto> get(InUserDto item);
   @RequestMapping(UserFeignConstant.FEIGN_EDIT)
    ResultItem<OutUserDto> edit(InUserDto item);
   @RequestMapping(UserFeignConstant.FEIGN_LIST)
    ResultItem<OutUserDto> list(InUserDto item);
   @RequestMapping(UserFeignConstant.FEIGN_DELETE)
    ResultItem<OutUserDto> delete(InUserDto item);
   @RequestMapping(UserFeignConstant.FEIGN_GETBYNAME)
    ResultItem<OutUserDto> getByName(InUserDto item);

}
