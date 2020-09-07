package com.mg.node.service.feign; 

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import com.mg.common.pojo.ResultItem;
import com.mg.node.common.service.feign.BaseFallBack;
import com.mg.node.constant.feign.UserFeignConstant;
import com.mg.node.pojo.dto.InUserDto;
import com.mg.node.pojo.dto.InUserDto;

@Component
@Slf4j
public class UserFeignFallBack implements UserFeign,BaseFallBack {
   String msg ="";
   public UserFeignFallBack(String msg) { this.msg = msg; }
   public UserFeignFallBack() { this.msg = "未添加异常提示！！"; }

   
   public ResultItem<InUserDto> get(InUserDto item){
      return fail(UserFeignConstant.FEIGN_SERVER_NAME,msg);
   }
   
   public ResultItem<InUserDto> edit(InUserDto item){
      return fail(UserFeignConstant.FEIGN_SERVER_NAME,msg);
   }
   
   public ResultItem<InUserDto> list(InUserDto item){
      return fail(UserFeignConstant.FEIGN_SERVER_NAME,msg);
   }
   
   public ResultItem<InUserDto> delete(InUserDto item){
      return fail(UserFeignConstant.FEIGN_SERVER_NAME,msg);
   }
   
   public ResultItem<InUserDto> getByName(InUserDto item){
      return fail(UserFeignConstant.FEIGN_SERVER_NAME,msg);
   }

}
