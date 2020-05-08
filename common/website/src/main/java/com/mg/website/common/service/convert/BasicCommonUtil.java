package com.mg.website.common.service.convert;

import com.mg.website.common.pojo.CommonData;
import com.mg.website.common.pojo.CommonItem;
import com.shineon.api.common.base.convert.CommonData;
import com.shineon.api.common.base.convert.CommonItemUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class BasicCommonUtil implements CommonItemUtils<String> {

    private CommonData toCommonData(String pojo) {
        CommonData data = new CommonData();
        data.setId(pojo);
        return data;
    }


    private String toPojoData( CommonData data) {
        String pojo = data.getId();
        return pojo;
    }


    public CommonItem toCommon(String pojo) {
        return success(toCommonData(pojo));
    }


    public CommonItem toCommon(List<String> pojos) {
        List<CommonData> result = new ArrayList();
        for(String item : pojos){
            result.add(toCommonData(item));
        }
        return success(result);
    }


    public String toPojo( CommonItem item) {
        List<CommonData> datas = item.getDatas();
        if(datas ==null||datas.size()==0){log.debug("CommonItem 中data数据为空!!"); return null;}
        if(datas.size()>1){log.debug("CommonItem 中data数据不止一条数据!!"); }
        return toPojoData(datas.get(0));
    }


    public List<String> toPojoList(  CommonItem item) {
        List<String> result = new ArrayList();
        List<CommonData> datas = item.getDatas();
        for(CommonData data : datas){
            result.add(toPojoData(data));
        }
        return result;
    }
}
