package com.mg.node.common.plugin.generate.action;

import com.mg.common.plugin.igenerate.ICreate;
import com.mg.common.unit.ClassUnit;
import com.mg.common.unit.MethodUnit;
import com.mg.common.util.StringUtil;
import com.mg.node.common.constant.ActionConstant;

import java.io.IOException;

public class CreateActionConstant  extends ICreate {
    public CreateActionConstant(String name, String[] methods) {
        super(name, methods);
    }

    @Override
    protected void createPre(ClassUnit unit) throws IOException {

    }

    @Override
    protected void createPreEachMethod(MethodUnit munit) throws IOException {
        munit.addPreLine(String.format("public static final String ACTION_%s =\"/%s/%s\";",
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
        return ActionConstant.ACTION_CONSTANT_PACKAGE;
    }

    @Override
    public String getClassName(String name) {
        return StringUtil.firstUpper(this.getName()) +"ControllerConstant";
    }
}
