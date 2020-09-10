package com.mg.website.service.feign; 

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import com.mg.common.pojo.ResultItem;
import com.mg.website.common.service.feign.BaseFallBack;
import com.mg.website.constant.feign.OauthFeignConstant;
import com.mg.website.pojo.dto.OutOauthDto;

@Component
@Slf4j
public class OauthFeignFallBack implements OauthFeign,BaseFallBack {
   String msg ="";
   public OauthFeignFallBack(String msg) { this.msg = msg; }
   public OauthFeignFallBack() { this.msg = "未添加异常提示！！"; }

   @Override
   public ResultItem token(String client_id, String client_secret, String grant_type, String username, String password) {
      return fail(OauthFeignConstant.FEIGN_SERVER_NAME,msg);
   }
}
