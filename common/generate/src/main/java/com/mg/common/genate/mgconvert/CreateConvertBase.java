package com.mg.common.genate.mgconvert;

import com.mg.common.genate.ibasic.ICreate;
import com.mg.common.util.ClassUtil;

import java.io.IOException;

public class CreateConvertBase extends ICreate {


    public CreateConvertBase(String name, Class toolClass, Class pojoClass, String[] methods, String sysName) {
        super(name, toolClass, pojoClass, methods, sysName);
    }

    @Override
    protected ClassUtil createClass() throws IOException {
        return null;
    }

    @Override
    protected void createPreMethod(ClassUtil classBuildUtil) throws IOException {

    }

    @Override
    protected void createMethod(ClassUtil classBuildUtil, String methodName) throws IOException {

    }

    @Override
    protected void createLastMethod(ClassUtil classBuildUtil) throws IOException {

    }

    @Override
    protected void classInit() {

    }

    @Override
    protected String getPackageName() {
        return null;
    }

    @Override
    protected String getClassNameLast() {
        return null;
    }
}
