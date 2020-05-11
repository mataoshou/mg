package com.mg.common.pojo;

import com.alibaba.fastjson.JSONObject;
import com.mg.common.util.Md5Util;

public interface IPojoBase {


    default String toJsonString()
    {
        return JSONObject.toJSONString(this);
    }

    default JSONObject toJson()
    {
        return (JSONObject) JSONObject.toJSON(this);
    }


    default String toCode(String sign) throws  Exception{
        return  sign + "." + Md5Util.digest(this.toJsonString());
    }

    default String toCode() throws  Exception{
        return  Md5Util.digest(this.toJsonString());
    }
}
