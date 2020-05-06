package com.mg.common.genate.mgconvert;

import com.mg.common.genate.ibasic.ICreate;

import java.io.IOException;

public class CreateConvertBase extends ICreate {


    public CreateConvertBase(String name, Class toolClass, Class pojoClass, String[] methods, String sysName) {
        super(name, methods);
    }


}
