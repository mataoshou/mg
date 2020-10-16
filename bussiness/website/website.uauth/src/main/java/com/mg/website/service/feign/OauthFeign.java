package com.mg.website.service.feign; 

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mg.common.pojo.ResultItem;
import com.mg.website.constant.feign.OauthFeignConstant;
import com.mg.website.pojo.dto.out.OutOauthDto;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = OauthFeignConstant.FEIGN_SERVER_NAME,fallbackFactory = OauthFeignFallBackFactory.class)
public interface OauthFeign {

    @RequestMapping(value = OauthFeignConstant.FEIGN_TOKEN,method = RequestMethod.GET)
    ResultItem<OutOauthDto> token(@RequestParam("client_id") String client_id,
                                  @RequestParam("client_secret")String client_secret,
                                  @RequestParam("grant_type")String grant_type,
                                  @RequestParam("username")String username,
                                  @RequestParam("password")String password);

}
