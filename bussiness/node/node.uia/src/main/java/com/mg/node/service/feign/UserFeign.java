package com.mg.node.service.feign; 

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mg.common.pojo.ResultItem;
import com.mg.node.constant.feign.UserFeignConstant;
import com.mg.node.pojo.dto.in.InUserDto;
import com.mg.node.pojo.dto.out.OutUserDto;

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

}
