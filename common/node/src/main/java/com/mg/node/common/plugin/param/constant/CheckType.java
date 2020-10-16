package com.mg.node.common.plugin.param.constant;

import com.mg.node.common.plugin.param.util.ParamsCheckUtil;

import java.util.function.BiFunction;

public enum CheckType {
    NONULL("noNull", ParamsCheckUtil::isNull),
    NOEMPTY("noEmpty",ParamsCheckUtil::isEmpty),
    DEFAULT("default",ParamsCheckUtil::defaultMethod);

    private String oper;
    BiFunction<Object,String,Boolean>  function;

    public String getOper() {
        return oper;
    }

    public void setOper(String oper) {
        this.oper = oper;
    }

    public BiFunction<Object, String, Boolean> getFunction() {
        return function;
    }

    public void setFunction(BiFunction<Object, String, Boolean> function) {
        this.function = function;
    }

    CheckType(String oper, BiFunction<Object,String,Boolean> function)
    {
        this.oper = oper;
        this.function = function;
    }
}
