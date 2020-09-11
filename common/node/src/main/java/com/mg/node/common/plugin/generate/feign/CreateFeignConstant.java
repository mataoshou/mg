package com.mg.node.common.plugin.generate.feign;

import com.mg.common.plugin.igenerate.ICreate;
import com.mg.common.unit.ClassUnit;
import com.mg.common.unit.MethodUnit;
import com.mg.common.util.StringUtil;
import com.mg.node.common.constant.FeignConstant;

import java.io.IOException;

public class CreateFeignConstant  extends ICreate {

    String sysName ;

    public CreateFeignConstant(String name, String[] methods,String sysName) {
        super(name, methods);
        this.sysName = sysName;
    }

    @Override
    protected void createPre(ClassUnit unit) throws IOException {
        unit.addPreContent(String.format("public static final String FEIGN_SERVER_NAME =\"%s\";",sysName));
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
