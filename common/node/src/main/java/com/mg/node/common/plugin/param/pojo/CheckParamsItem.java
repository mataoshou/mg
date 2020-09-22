package com.mg.node.common.plugin.param.pojo;

import com.mg.node.common.plugin.param.constant.CheckType;
import lombok.Data;

@Data
public class CheckParamsItem {

    private String param;
    private CheckType checkType;
    private String msg;
    private Object value;

    public CheckParamsItem(String param,CheckType checkType,String msg)
    {
        this.param = param;
        this.checkType = checkType;
        this.msg = msg;
    }

}
