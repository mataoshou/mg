package com.mg.website.common.generate.action;

import com.mg.common.iservice.ibasic.ICreate;
import com.mg.common.unit.ClassUnit;
import com.mg.common.unit.MethodUnit;

import java.io.IOException;

public class CreateDTO extends ICreate {


    public CreateDTO(String name, String[] methods) {
        super(name, methods);
    }

    @Override
    protected void createPreMethod(ClassUnit unit) throws IOException {

    }

    @Override
    protected void createMethod(MethodUnit unit) throws IOException {

    }

    @Override
    protected void classInit(ClassUnit unit) {

    }

    @Override
    protected String getPackageName() {
        return null;
    }

    @Override
    public String getClassName(String name) {
        return null;
    }
}
