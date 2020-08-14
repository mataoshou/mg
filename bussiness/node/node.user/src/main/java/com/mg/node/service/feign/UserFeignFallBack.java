package com.mg.node.service.feign; 

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import com.mg.common.pojo.ResultItem;
import com.mg.node.common.service.feign.BaseFallBack;
import com.mg.node.constant.feign.UserFeignConstant;
import com.mg.node.pojo.dto.InUserDto;
import com.mg.node.pojo.dto.OutUserDto;

@Component
@Slf4j
public class UserFeignFallBack implements UserFeign,BaseFallBack {

   
   public ResultItem<OutUserDto> get(InUserDto item){
      return fail(UserFeignConstant.FEIGN_SERVER_NAME);
   }
   
   public ResultItem<OutUserDto> insert(InUserDto item){
      return fail(UserFeignConstant.FEIGN_SERVER_NAME);
   }
   
   public ResultItem<OutUserDto> list(InUserDto item){
      return fail(UserFeignConstant.FEIGN_SERVER_NAME);
   }
   
   public ResultItem<OutUserDto> update(InUserDto item){
      return fail(UserFeignConstant.FEIGN_SERVER_NAME);
   }
   
   public ResultItem<OutUserDto> delete(InUserDto item){
      return fail(UserFeignConstant.FEIGN_SERVER_NAME);
   }
   
   public ResultItem<InUserDto> getByName(InUserDto item){
      return fail(UserFeignConstant.FEIGN_SERVER_NAME);
   }



}
