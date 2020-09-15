package com.mg.compose.service.feign; 

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import com.mg.common.pojo.ResultItem;
import com.mg.compose.common.service.feign.BaseFallBack;
import com.mg.compose.constant.feign.SiteFeignConstant;
import com.mg.compose.pojo.dto.InSite;
import com.mg.compose.pojo.dto.OutSite;

@Component
@Slf4j
public class SiteFeignFallBack implements SiteFeign,BaseFallBack {
   String msg ="";
   public SiteFeignFallBack(String msg) { this.msg = msg; }
   public SiteFeignFallBack() { this.msg = "未添加异常提示！！"; }

   
   public ResultItem<OutSite> get(InSite item){
      return fail(SiteFeignConstant.FEIGN_SERVER_NAME,msg);
   }
   
   public ResultItem<OutSite> edit(InSite item){
      return fail(SiteFeignConstant.FEIGN_SERVER_NAME,msg);
   }
   
   public ResultItem<OutSite> list(InSite item){
      return fail(SiteFeignConstant.FEIGN_SERVER_NAME,msg);
   }
   
   public ResultItem<OutSite> delete(InSite item){
      return fail(SiteFeignConstant.FEIGN_SERVER_NAME,msg);
   }

}
