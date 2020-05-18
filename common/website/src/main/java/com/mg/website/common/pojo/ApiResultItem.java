package com.mg.website.common.pojo;

import java.util.ArrayList;
import java.util.List;

public class ApiResultItem<T> {

    private Integer code;

    private String msg;

    private List<T> data = new ArrayList();

    public ApiResultItem( List<T> data) throws Exception {

        this.msg = "ok";
        this.code = 100;

        this.data = data;

    }

    public ApiResultItem( T t) throws Exception {

        this.msg = "ok";
        this.code = 100;

        this.data.add(t);

    }

    public ApiResultItem( int code,String msg) throws Exception {

        this.msg = msg;
        this.code = code;
    }

    public ApiResultItem()
    {
        this.msg = "ok";
        this.code = 100;
    }



    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T get()
    {
        if(this.data==null||this.data.size()==0)return null;
        return this.data.get(0);
    }

    public List<T> list()
    {
        if(this.data==null||this.data.size()==0)return null;
        return this.data;
    }

}
