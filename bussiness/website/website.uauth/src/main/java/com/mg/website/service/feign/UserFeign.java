package com.mg.website.service.feign; 

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mg.common.pojo.ResultItem;
import com.mg.website.constant.feign.UserFeignConstant;
import com.mg.website.pojo.dto.out.OutUserDto;
import com.mg.website.pojo.dto.in.InUserDto;

@FeignClient(name = UserFeignConstant.FEIGN_SERVER_NAME,fallbackFactory = UserFeignFallBackFactory.class)
public interface UserFeign {

   @RequestMapping(UserFeignConstant.FEIGN_GET)
    ResultItem<InUserDto> get(OutUserDto item);
   @RequestMapping(UserFeignConstant.FEIGN_EDIT)
    ResultItem<InUserDto> edit(OutUserDto item);
   @RequestMapping(UserFeignConstant.FEIGN_LIST)
    ResultItem<InUserDto> list(OutUserDto item);
   @RequestMapping(UserFeignConstant.FEIGN_DELETE)
    ResultItem<InUserDto> delete(OutUserDto item);

}
