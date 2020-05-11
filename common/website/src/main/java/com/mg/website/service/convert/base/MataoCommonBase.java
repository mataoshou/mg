package com.mg.website.service.convert.base; 

import com.mg.common.pojo.SimpleItem;
import com.mg.common.pojo.CommonData;
import java.util.ArrayList;
import java.util.List;
import com.mg.website.common.service.convert.CommonItemUtils;
import com.mg.common.pojo.CommonItem;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MataoCommonBase implements CommonItemUtils<SimpleItem> {

   
   private CommonData toCommonData(SimpleItem pojo) {
      CommonData data = new CommonData();
      data.addParam("key",pojo.getKey());
      data.addParam("value",pojo.getValue());
      return data;
   }

   
   private SimpleItem toPojoData(CommonData data) {
      SimpleItem pojo = new SimpleItem();
      pojo.setKey(data.getString("key"));
      pojo.setValue(data.getString("value"));
      return pojo;
   }

   @Override
   public CommonItem toCommon(SimpleItem pojo) {
         return success(toCommonData(pojo));
   }

   @Override
   public CommonItem toCommon(List<SimpleItem> pojos) {
      List<CommonData> result = new ArrayList();
      for(SimpleItem item : pojos){
         result.add(toCommonData(item));
      }
      return success(result);
   }

   @Override
   public SimpleItem toPojo(CommonItem item) throws Exception{
      checkCommonItem(item);
      List<CommonData> datas = item.getDatas();
      if(datas ==null||datas.size()==0){log.debug("CommonItem 中data数据为空!!"); return null;}
      if(datas.size()>1){log.debug("CommonItem 中data数据不止一条数据!!"); }
      return toPojoData(datas.get(0));
   }

   @Override
   public List<SimpleItem> toPojoList(CommonItem item) throws Exception{
      checkCommonItem(item);
      List<SimpleItem> result = new ArrayList();
      List<CommonData> datas = item.getDatas();
      for(CommonData data : datas){
         result.add(toPojoData(data));
      }
      return result;
   }


}
