package com.mg.website.common.generate.convert;


import com.mg.common.iservice.ibasic.ICreate;
import com.mg.common.unit.ClassUnit;
import com.mg.common.unit.MethodUnit;
import com.mg.common.util.StringUtil;
import com.mg.website.common.constant.ConvertsConstant;

import java.io.IOException;

public class CreateConvertUtil extends ICreate {


    String baseName = this.getName() + "CommonBase";

    public CreateConvertUtil(String name) {
        super(name, null);
    }

    @Override
    protected void createPre(ClassUnit unit) throws IOException {

    }

    @Override
    protected void createPreEachMethod(MethodUnit munit) throws IOException {

    }

    @Override
    protected void createMethod(MethodUnit unit) throws IOException {

    }

    @Override
    protected void classInit(ClassUnit unit) {

        unit.setBaseName(baseName);
        unit.addAnnotion("Service");
        unit.addImport("org.springframework.stereotype.Service");
        unit.addImport(ConvertsConstant.BASE_PACKAGE +"." +baseName);
    }

    @Override
    protected String getPackageName() {
        return ConvertsConstant.UTIL_PACKAGE;
    }

    @Override
    public String getClassName(String name) {
        return StringUtil.firstUpper(name) +"CommonUtil";
    }
}
