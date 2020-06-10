package com.mg.common.pojo;

public enum  ResultEnum {
    SUCCESS(100,"ok"),FAIL(-1,"error");

    private int code;
    private String msg;

    private ResultEnum(int code,String msg)
    {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
