package com.shineon.api.action; 

import com.mg.website.common.pojo.ApiResultItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mg.website.common.service.convert.CommonItem;
import org.springframework.beans.factory.annotation.Autowired;
import com.shineon.api.service.dto.MataoDTO;
import com.shineon.api.constant.action.MataoControllerConstant;
import org.springframework.web.bind.annotation.RequestBody;
import com.alibaba.fastjson.JSONObject;
import com.shineon.api.common.base.db.ApiResultItem;
import com.mg.common.pojo.SimpleItem;


public class MataoController {
   @Autowired
   MataoDTO dto;
   

   @Autowired
   com.mg.website.common.pojo.ApiResultItem commonUtil;

   @RequestMapping(MataoControllerConstant.ACTION_GET)
   public ApiResultItem get(@RequestBody JSONObject params) {
      SimpleItem pojo = new SimpleItem();
      pojo.setId(params.getString("id"));
      return dto.get(commonUtil.toCommon(pojo));
   }

   @RequestMapping(MataoControllerConstant.ACTION_LIST)
   public ApiResultItem list(@RequestBody JSONObject params) {
         return dto.list(commonUtil.success());
   }


}
