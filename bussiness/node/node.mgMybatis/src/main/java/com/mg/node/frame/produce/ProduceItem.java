package com.mg.node.frame.produce;

import java.util.HashMap;
import java.util.Map;

public class ProduceItem {

    private Class pojo;

    private Class template;

    private Class imp;

    private Map<String,String> params = new HashMap<>();


    public Class getPojo() {
        return pojo;
    }

    public void setPojo(Class pojo) {
        this.pojo = pojo;
    }

    public Class getTemplate() {
        return template;
    }

    public void setTemplate(Class template) {
        this.template = template;
    }

    public Class getImp() {
        return imp;
    }

    public void setImp(Class imp) {
        this.imp = imp;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public void addParam(String key,String value)
    {
        this.params.put(key,value);
    }
}
