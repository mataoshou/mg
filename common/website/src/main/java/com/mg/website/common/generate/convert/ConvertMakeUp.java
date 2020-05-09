package com.mg.website.common.generate.convert;

import com.shineon.db.common.create.ibase.IMakeUpBase;

public class ConvertMakeUp extends IMakeUpBase {


    public ConvertMakeUp(String name, Class toolClass, Class pojoClass, String[] methods, String sysName) {
        super(name, toolClass, pojoClass, methods, sysName);
        add( new CreateConvertMapper(name,toolClass,pojoClass,methods, sysName));
        add( new CreateConvertBase(name,toolClass,pojoClass,methods, sysName));
        add( new CreateConvertUtil(name,toolClass,pojoClass,methods, sysName));
    }

}
