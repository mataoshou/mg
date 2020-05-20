package com.mg.website.common.action.sys;

import lombok.Data;

@Data
public class SysItem {
    private String name;
    private String inDtoName;
    private String outDtoName;
    private String inVoName;
    private String outVoName;
    private String inBoName;
    private String outBoName;

    private String poName;

    private String repositoryName;
    private String sysName;
    private String oper;
    private String[] methods;
    private int createType;

    public void setOper(String oper) {
        this.oper = oper;
        this.methods= this.oper.split(",");
    }


}
