package com.mg.compose.common.generate.feign;

import com.mg.common.iservice.ibasic.ICreate;
import com.mg.common.unit.ClassUnit;
import com.mg.common.unit.MethodUnit;
import com.mg.common.util.StringUtil;
import com.mg.compose.common.constant.FeignConstant;

import java.io.IOException;

public class CreateFeignConstant  extends ICreate {
    public CreateFeignConstant(String name, String[] methods) {
        super(name, methods);
    }

    @Override
    protected void createPre(ClassUnit unit) throws IOException {

    }

    @Override
    protected void createPreEachMethod(MethodUnit munit) throws IOException {
        munit.addPreLine(String.format("public static final String FEIGN_%s =\"/%s/%s\";",
                munit.getName().toUpperCase(),this.getName(),munit.getName()));
    }

    @Override
    protected void createMethod(MethodUnit unit) throws IOException {
        unit.setDisabled();
    }

    @Override
    protected void classInit(ClassUnit unit) {

    }

    @Override
    protected String getPackageName() {
        return FeignConstant.FEIGN_CONSTANT_PACKAGE;
    }

    @Override
    public String getClassName(String name) {
        return StringUtil.firstUpper(name) +"FeignConstant";
    }
}