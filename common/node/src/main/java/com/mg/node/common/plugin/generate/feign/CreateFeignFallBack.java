package com.mg.node.common.plugin.generate.feign;

import com.mg.common.constant.BasicCommonConstant;
import com.mg.common.plugin.igenerate.ICreate;
import com.mg.common.unit.ClassUnit;
import com.mg.common.unit.MethodUnit;
import com.mg.common.util.StringUtil;
import com.mg.node.common.constant.FeignConstant;

import java.io.IOException;

public class CreateFeignFallBack extends ICreate {

    Class incl;
    Class outcl;

    public CreateFeignFallBack(String name, String[] methods,Class inCl,Class outCl) {
        super(name, methods);
        this.incl =inCl;
        this.outcl = outCl;
    }

    @Override
    protected void createPre(ClassUnit unit) throws IOException {
        unit.addPreContent("String msg =\"\";");
        unit.addPreContent(String.format("public %s(String msg) { this.msg = msg; }",unit.getName()));
        unit.addPreContent(String.format("public %s() { this.msg = \"未添加异常提示！！\"; }",unit.getName()));
    }

    @Override
    protected void createPreEachMethod(MethodUnit munit) throws IOException {

    }

    String feignName = StringUtil.firstUpper(this.getName()) +"Feign";
    String constantClassName = StringUtil.firstUpper(this.getName()) +"FeignConstant";

    @Override
    protected void createMethod(MethodUnit unit) throws IOException {
        unit.setReturnValue(String.format("ResultItem<%s>",outcl.getSimpleName()));
        unit.addParam(incl.getSimpleName(),"item");
        unit.setDecorate("public");


        unit.addTabContent(String.format("return fail(%s.FEIGN_SERVER_NAME,msg);", constantClassName));
    }

    @Override
    protected void classInit(ClassUnit unit) {
        unit.addImplement(feignName);
        unit.addImplement("BaseFallBack");

        unit.addImport(new String[]{
                "lombok.extern.slf4j.Slf4j",
                "org.springframework.stereotype.Component",
                BasicCommonConstant.POJO_COMMON +".ResultItem",
                FeignConstant.FEIGN_COMMON_PACKAGE +".BaseFallBack",
                FeignConstant.FEIGN_CONSTANT_PACKAGE +"." +constantClassName,
                this.incl.getName(),
                this.outcl.getName()
        });

        unit.addAnnotion("Component");
        unit.addAnnotion("Slf4j");
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
