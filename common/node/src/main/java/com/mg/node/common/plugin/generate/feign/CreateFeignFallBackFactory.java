package com.mg.node.common.plugin.generate.feign;

import com.mg.common.plugin.igenerate.ICreate;
import com.mg.common.unit.ClassUnit;
import com.mg.common.unit.MethodUnit;
import com.mg.common.util.StringUtil;
import com.mg.node.common.constant.FeignConstant;

import java.io.IOException;

public class CreateFeignFallBackFactory  extends ICreate {
    public CreateFeignFallBackFactory(String name) {
        super(name,new String[]{"create"});
    }

    @Override
    protected void createPre(ClassUnit unit) throws IOException {

    }

    @Override
    protected void createPreEachMethod(MethodUnit munit) throws IOException {

    }

    @Override
    protected void createMethod(MethodUnit unit) throws IOException {

        unit.setDecorate("public");
        unit.addAnnotation("Override");
        unit.setReturnValue(String.format("%sFeign", StringUtil.firstUpper(this.getName())));
        unit.addParam("Throwable","cause");
        unit.addTabContent("log.info(cause.getMessage());");
        unit.addTabContent("cause.printStackTrace();");
        unit.addTabContent(String.format("return new %sFeignFallBack(cause.getMessage());",StringUtil.firstUpper(this.getItem().getName())));

    }

    @Override
    protected void classInit(ClassUnit unit) {
        unit.addImplement(String.format("FallbackFactory<%sFeign>", StringUtil.firstUpper(this.getName())));
        unit.addImport("org.springframework.stereotype.Component");
        unit.addImport("lombok.extern.slf4j.Slf4j");
        unit.addImport("feign.hystrix.FallbackFactory");
        unit.addAnnotion("Slf4j");
        unit.addAnnotion("Component");

    }

    @Override
    protected String getPackageName() {
        return FeignConstant.FEIGN_PACKAGE;
    }

    @Override
    public String getClassName(String name) {
        return StringUtil.firstUpper(name) +"FeignFallBackFactory";
    }
}
