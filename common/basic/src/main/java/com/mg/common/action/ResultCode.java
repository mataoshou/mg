package com.mg.common.action;

public enum ResultCode {

    STATUS_SUCCESS(100,"success"),
    STATUS_FAIL(-1,"not get reason");


    private int index;
    String message;

    // 构造方法
    private ResultCode(int index, String message) {
        this.index = index;
        this.message = message;
    }
}
