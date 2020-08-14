package com.mg.common.action;

public class MgApiException extends Exception {
    public MgApiException(int code,String msg)
    {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    private int code;
    private String msg;

    public int getCode()
    {
        return code;
    }

    public String getMsg()
    {
        return msg;
    }



}
