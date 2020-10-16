package com.mg.node.service.feign; 

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import com.mg.common.pojo.ResultItem;
import com.mg.node.common.service.feign.BaseFallBack;
import com.mg.node.constant.feign.UserFeignConstant;
import com.mg.node.pojo.dto.in.InUserDto;
import com.mg.node.pojo.dto.out.OutUserDto;

@Component
@Slf4j
public class UserFeignFallBack implements UserFeign,BaseFallBack {
   String msg ="";
   public UserFeignFallBack(String msg) { this.msg = msg; }
   public UserFeignFallBack() { this.msg = "未添加异常提示！！"; }

   
   public ResultItem<OutUserDto> get(InUserDto item){
      return fail(UserFeignConstant.FEIGN_SERVER_NAME,msg);
   }
   
   public ResultItem<OutUserDto> edit(InUserDto item){
      return fail(UserFeignConstant.FEIGN_SERVER_NAME,msg);
   }
   
   public ResultItem<OutUserDto> list(InUserDto item){
      return fail(UserFeignConstant.FEIGN_SERVER_NAME,msg);
   }
   
   public ResultItem<OutUserDto> delete(InUserDto item){
      return fail(UserFeignConstant.FEIGN_SERVER_NAME,msg);
   }

}
