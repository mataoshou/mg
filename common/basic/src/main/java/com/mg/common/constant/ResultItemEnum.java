package com.mg.common.constant;

public enum ResultItemEnum {
    RESULT_ENUM_SUCCESS(100,"success"),
    RESULT_ENUM_DENY(-99,"禁止访问"),
    RESULT_ENUM_AUTH(-16,"没有权限"),
    RESULT_ENUM_FAIL(-1,"fail");

    private int code;
    private String msg;

    ResultItemEnum(int code, String msg)
    {
        this.code = code;
        this.msg = msg;
    }

    public final int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
