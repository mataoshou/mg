package com.mg.website.service.feign; 

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import com.mg.common.pojo.ResultItem;
import com.mg.website.common.service.feign.BaseFallBack;
import com.mg.website.constant.feign.UserFeignConstant;
import com.mg.website.pojo.dto.OutUserDto;
import com.mg.website.pojo.dto.InUserDto;

@Component
@Slf4j
public class UserFeignFallBack implements UserFeign,BaseFallBack {
   String msg ="";
   public UserFeignFallBack(String msg) { this.msg = msg; }
   public UserFeignFallBack() { this.msg = "未添加异常提示！！"; }

   
   public ResultItem get(OutUserDto item){
      return fail(UserFeignConstant.FEIGN_SERVER_NAME,msg);
   }
   
   public ResultItem edit(OutUserDto item){
      return fail(UserFeignConstant.FEIGN_SERVER_NAME,msg);
   }
   
   public ResultItem list(OutUserDto item){
      return fail(UserFeignConstant.FEIGN_SERVER_NAME,msg);
   }
   
   public ResultItem delete(OutUserDto item){
      return fail(UserFeignConstant.FEIGN_SERVER_NAME,msg);
   }

}
