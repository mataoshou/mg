package com.mg.website.service.feign; 

import com.mg.website.pojo.dto.OutOauthDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import com.mg.common.pojo.ResultItem;
import com.mg.website.common.service.feign.BaseFallBack;
import com.mg.website.constant.feign.FreeFeignConstant;
import com.mg.website.pojo.dto.InOauthDto;

@Component
@Slf4j
public class FreeFeignFallBack implements FreeFeign,BaseFallBack {

   
   public ResultItem login(String client_id, String client_secret, String grant_type,
                                        String username, String password){
      return fail(FreeFeignConstant.FEIGN_SERVER_NAME,"");
   }

   @Override
   public ResultItem login(InOauthDto dto) {
      return fail(FreeFeignConstant.FEIGN_SERVER_NAME,"");
   }

}
