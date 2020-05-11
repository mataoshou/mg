package com.mg.common.pojo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;


@Component
@Scope("prototype")
public class CommonData {

    private HashMap<String ,Double> dParams = new HashMap<>();

    private HashMap<String ,Long> lParams = new HashMap<>();

    private HashMap<String ,Integer> iParams = new HashMap<>();

    private HashMap<String ,String> sParams = new HashMap<>();

    private HashMap<String ,Object> oParams = new HashMap<>();


    public HashMap<String, Double> getdParams() {
        return dParams;
    }

    public HashMap<String, Long> getlParams() {
        return lParams;
    }

    public HashMap<String, Integer> getiParams() {
        return iParams;
    }

    public HashMap<String, String> getsParams() {
        return sParams;
    }

    public HashMap<String, Object> getoParams() {
        return oParams;
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
        return getLong(key,0L);
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

    public Date getDate(String key)
    {
        return new Date(getLong(key));
    }
}
