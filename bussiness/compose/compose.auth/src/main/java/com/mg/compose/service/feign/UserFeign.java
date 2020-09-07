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

   @RequestMapping(UserFeignConstant.FEIGN_GETBYNAME)
    ResultItem<OutUserDto> getByName(InUserDto item);

}
