package com.mg.common.pojo;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CommonItem {

    List<CommonData> datas;

    private Integer errorStatus;

    private String errorReason;

    public Integer getErrorStatus() {
        return errorStatus;
    }

    public void setErrorStatus(Integer errorStatus) {
        this.errorStatus = errorStatus;
    }

    public String getErrorReason() {
        return errorReason;
    }

    public void setErrorReason(String errorReason) {
        this.errorReason = errorReason;
    }


    public List<CommonData> getDatas() {
        return datas;
    }

    public void setDatas(List<CommonData> datas) {
        this.datas = datas;
    }

    public void addData(CommonData data) {
        if(datas ==null){
            datas = new ArrayList();
        }
        this.datas.add(data);
    }

    public String toJsonString ()
    {
        return JSONObject.toJSONString(this);
    }

    public JSONObject toJson()
    {
        return (JSONObject) JSONObject.toJSON(this);
    }
}
