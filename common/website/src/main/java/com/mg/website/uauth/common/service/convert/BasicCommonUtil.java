package com.mg.website.uauth.common.service.convert;

import com.mg.common.pojo.CommonData;
import com.mg.common.pojo.CommonItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class BasicCommonUtil implements CommonItemUtils<String> {

    private CommonData toCommonData(String pojo) {
        CommonData data = new CommonData();
        data.addParam("key",pojo);
        return data;
    }


    private String toPojoData( CommonData data) {
        String pojo = data.getString("key");
        return pojo;
    }


    @Override
    public CommonItem toCommon(String pojo) {
        return success(toCommonData(pojo));
    }


    @Override
    public CommonItem toCommon(List<String> pojos) {
        List<CommonData> result = new ArrayList();
        for(String item : pojos){
            result.add(toCommonData(item));
        }
        return success(result);
    }


    @Override
    public String toPojo(CommonItem item) {
        List<CommonData> datas = item.getDatas();
        if(datas ==null||datas.size()==0){log.debug("CommonItem 中data数据为空!!"); return null;}
        if(datas.size()>1){log.debug("CommonItem 中data数据不止一条数据!!"); }
        return toPojoData(datas.get(0));
    }


    @Override
    public List<String> toPojoList(CommonItem item) {
        List<String> result = new ArrayList();
        List<CommonData> datas = item.getDatas();
        for(CommonData data : datas){
            result.add(toPojoData(data));
        }
        return result;
    }
}
