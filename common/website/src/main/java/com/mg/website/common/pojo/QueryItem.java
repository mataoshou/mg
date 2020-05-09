package com.mg.website.common.pojo;

import com.alibaba.fastjson.JSONObject;
import com.mg.common.util.Md5Util;

import java.util.Date;
import java.util.HashMap;

public class QueryItem implements IPojoBase {

    private HashMap<String ,Double> dParams = new HashMap<>();

    private HashMap<String ,Long> lParams = new HashMap<>();

    private HashMap<String ,Integer> iParams = new HashMap<>();

    private HashMap<String ,String> sParams = new HashMap<>();

    private HashMap<String ,Object> oParams = new HashMap<>();


    public void setdParams(HashMap<String, Double> dParams) {
        this.dParams = dParams;
    }

    public void setlParams(HashMap<String, Long> lParams) {
        this.lParams = lParams;
    }

    public void setiParams(HashMap<String, Integer> iParams) {
        this.iParams = iParams;
    }

    public void setsParams(HashMap<String, String> sParams) {
        this.sParams = sParams;
    }

    public void setoParams(HashMap<String, Object> oParams) {
        this.oParams = oParams;
    }

    public void addParam(String key, Object value)
    {
        if(value instanceof Double)
        {
            dParams.put(key, (Double) value);
        }
        else if(value instanceof Long)
        {
            lParams.put(key, (Long) value);
        }
        else if(value instanceof Integer)
        {
            iParams.put(key, (Integer) value);
        }
        else if(value instanceof String)
        {
            sParams.put(key, value.toString());
        }
        else
        {
            oParams.put(key, value.toString());
        }
    }


    public Double getDouble(String key,double def)
    {
        Double result = dParams.get(key);
        if(result==null)
        {
            return def;
        }
        return result;
    }

    public Double getDouble(String key)
    {
        return getDouble(key,0);
    }

    public Long getLong(String key,Long def)
    {
        Long result = lParams.get(key);
        if(result==null)
        {
            return def;
        }
        return result;
    }

    public Long getLong(String key)
    {
        return getLong(key);
    }


    public Integer getInteger(String key,Integer def)
    {
        Integer result = iParams.get(key);
        if(result==null)
        {
            return def;
        }
        return result;
    }

    public Integer getInteger(String key)
    {
        return getInteger(key,0);
    }

    public String getString(String key,String def)
    {
        String result = sParams.get(key);
        if(result==null)
        {
            return def;
        }
        return result;
    }

    public String getString(String key)
    {
        return getString(key,"");
    }


    public Date getDate(String key)
    {
        return new Date(getLong(key));
    }

    public Object getObject(String key,Object def)
    {
        Object result = oParams.get(key);
        if(result==null)
        {
            return def;
        }
        return result;
    }

    public Object getObject(String key)
    {
        return getObject(key,null);
    }


}
