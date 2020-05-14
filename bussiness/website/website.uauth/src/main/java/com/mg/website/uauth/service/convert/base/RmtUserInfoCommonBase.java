package com.mg.website.uauth.service.convert.base;

import com.mg.website.uauth.db.pojo.RmtUserInfo;
import com.mg.common.pojo.CommonData;
import java.util.ArrayList;
import java.util.List;
import com.mg.website.uauth.common.service.convert.CommonItemUtils;
import com.mg.common.pojo.CommonItem;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RmtUserInfoCommonBase implements CommonItemUtils<RmtUserInfo> {

   
   private CommonData toCommonData(RmtUserInfo pojo){
      CommonData data = new CommonData();
      data.addParam("id",pojo.getId());
      data.addParam("usercode",pojo.getUsercode());
      data.addParam("username",pojo.getUsername());
      data.addParam("userpassword",pojo.getUserpassword());
      data.addParam("displayname",pojo.getDisplayname());
      data.addParam("userthumb",pojo.getUserthumb());
      data.addParam("workcode",pojo.getWorkcode());
      data.addParam("oganizationid",pojo.getOganizationid());
      data.addParam("departmentid",pojo.getDepartmentid());
      data.addParam("userextendid",pojo.getUserextendid());
      data.addParam("createdtime",pojo.getCreatedtime());
      data.addParam("createuserid",pojo.getCreateuserid());
      data.addParam("modifytime",pojo.getModifytime());
      data.addParam("modifyuserid",pojo.getModifyuserid());
      data.addParam("limitedtime",pojo.getLimitedtime());
      data.addParam("logincount",pojo.getLogincount());
      data.addParam("selectcondition",pojo.getSelectcondition());
      data.addParam("systemuserflag",pojo.getSystemuserflag());
      return data;
   }
   
   private RmtUserInfo toPojoData(CommonData data){
      RmtUserInfo pojo = new RmtUserInfo();
      pojo.setId(data.getString("id"));
      pojo.setUsercode(data.getString("usercode"));
      pojo.setUsername(data.getString("username"));
      pojo.setUserpassword(data.getString("userpassword"));
      pojo.setDisplayname(data.getString("displayname"));
      pojo.setUserthumb(data.getString("userthumb"));
      pojo.setWorkcode(data.getString("workcode"));
      pojo.setOganizationid(data.getString("oganizationid"));
      pojo.setDepartmentid(data.getString("departmentid"));
      pojo.setUserextendid(data.getString("userextendid"));
      pojo.setCreatedtime(data.getDate("createdtime"));
      pojo.setCreateuserid(data.getString("createuserid"));
      pojo.setModifytime(data.getDate("modifytime"));
      pojo.setModifyuserid(data.getString("modifyuserid"));
      pojo.setLimitedtime(data.getDate("limitedtime"));
      pojo.setLogincount(data.getInteger("logincount").byteValue());
      pojo.setSelectcondition(data.getInteger("selectcondition").byteValue());
      pojo.setSystemuserflag(data.getInteger("systemuserflag").byteValue());
      return pojo;
   }
   @Override
   public CommonItem toCommon(RmtUserInfo pojo){
         return success(toCommonData(pojo));
   }
   @Override
   public CommonItem toCommon(List<RmtUserInfo> pojos){
      List<CommonData> result = new ArrayList();
      for(RmtUserInfo item : pojos){
         result.add(toCommonData(item));
      }
      return success(result);
   }
   @Override
   public RmtUserInfo toPojo(CommonItem item) throws Exception{
      checkCommonItem(item);
      List<CommonData> datas = item.getDatas();
      if(datas ==null||datas.size()==0){log.debug("CommonItem 中data数据为空!!"); return null;}
      if(datas.size()>1){log.debug("CommonItem 中data数据不止一条数据!!"); }
      return toPojoData(datas.get(0));
   }
   @Override
   public List<RmtUserInfo> toPojoList(CommonItem item) throws Exception{
      checkCommonItem(item);
      List<RmtUserInfo> result = new ArrayList();
      List<CommonData> datas = item.getDatas();
      for(CommonData data : datas){
         result.add(toPojoData(data));
      }
      return result;
   }

}
