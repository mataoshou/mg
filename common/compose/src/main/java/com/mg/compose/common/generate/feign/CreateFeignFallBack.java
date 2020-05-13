package com.mg.compose.common.generate.feign;

import com.mg.common.constant.ConverCommonConstant;
import com.mg.common.iservice.ibasic.ICreate;
import com.mg.common.unit.ClassUnit;
import com.mg.common.unit.MethodUnit;
import com.mg.common.util.StringUtil;
import com.mg.compose.common.constant.FeignConstant;

import java.io.IOException;

public class CreateFeignFallBack extends ICreate {


    public CreateFeignFallBack(String name, String[] methods) {
        super(name, methods);
    }

    @Override
    protected void createPre(ClassUnit unit) throws IOException {

    }

    @Override
    protected void createPreEachMethod(MethodUnit munit) throws IOException {

    }

    String feignName = StringUtil.firstUpper(this.getName()) +"Feign";
    String constantClassName = StringUtil.firstUpper(this.getName()) +"FeignConstant";

    @Override
    protected void createMethod(MethodUnit unit) throws IOException {
        unit.setReturnValue("CommonItem");
        unit.addParam("CommonItem","item");
        unit.addTabLeftContent(String.format("fail(%s.FEIGN_SERVER_NAME);",constantClassName));
    }

    @Override
    protected void classInit(ClassUnit unit) {
        unit.addImplement(feignName);
        unit.addImplement("BaseFallBack");

        unit.addImport(new String[]{
                "lombok.extern.slf4j.Slf4j",
                ConverCommonConstant.CONVERT_COMMON_POJO+".CommonItem","org.springframework.stereotype.Component",
                FeignConstant.FEIGN_COMMON_PACKAGE +".BaseFallBack",
                FeignConstant.FEIGN_CONSTANT_PACKAGE +"." +constantClassName
        });
    }

    @Override
    protected String getPackageName() {
        return FeignConstant.FEIGN_PACKAGE;
    }

    @Override
    public String getClassName(String name) {
        return StringUtil.firstUpper(name) +"FeignFallBack";
    }
}
