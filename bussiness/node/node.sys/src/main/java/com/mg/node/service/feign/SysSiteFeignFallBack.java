package com.mg.node.service.feign; 

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import com.mg.common.pojo.ResultItem;
import com.mg.node.common.service.feign.BaseFallBack;
import com.mg.node.constant.feign.SysSiteFeignConstant;
import com.mg.node.pojo.dto.InSysSiteDto;
import com.mg.node.pojo.dto.OutSysSiteDto;

@Component
@Slf4j
public class SysSiteFeignFallBack implements SysSiteFeign,BaseFallBack {
   String msg ="";
   public SysSiteFeignFallBack(String msg) { this.msg = msg; }
   public SysSiteFeignFallBack() { this.msg = "未添加异常提示！！"; }

   
   public ResultItem<OutSysSiteDto> get(InSysSiteDto item){
      return fail(SysSiteFeignConstant.FEIGN_SERVER_NAME,msg);
   }
   
   public ResultItem<OutSysSiteDto> insert(InSysSiteDto item){
      return fail(SysSiteFeignConstant.FEIGN_SERVER_NAME,msg);
   }
   
   public ResultItem<OutSysSiteDto> list(InSysSiteDto item){
      return fail(SysSiteFeignConstant.FEIGN_SERVER_NAME,msg);
   }
   
   public ResultItem<OutSysSiteDto> update(InSysSiteDto item){
      return fail(SysSiteFeignConstant.FEIGN_SERVER_NAME,msg);
   }
   
   public ResultItem<OutSysSiteDto> delete(InSysSiteDto item){
      return fail(SysSiteFeignConstant.FEIGN_SERVER_NAME,msg);
   }
   
   public ResultItem<OutSysSiteDto> getByName(InSysSiteDto item){
      return fail(SysSiteFeignConstant.FEIGN_SERVER_NAME,msg);
   }

}
