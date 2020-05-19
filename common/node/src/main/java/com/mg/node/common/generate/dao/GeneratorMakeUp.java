package com.mg.node.common.generate.dao;


import com.mg.common.iservice.ibasic.IMakeUpBase;

public class GeneratorMakeUp extends IMakeUpBase {
    public GeneratorMakeUp(String name, Class toolClass, Class pojoClass, String[] methods, String sysName) {
        super(name, toolClass, pojoClass, methods, sysName);

        add(new CreateBaseDao(name,toolClass,pojoClass,methods,sysName));
        add(new CreateBaseMapper(name,toolClass,pojoClass,methods,sysName));
        add(new CreateExternDao(name,toolClass,pojoClass,methods,sysName));
        add(new CreateExternMapper(name,toolClass,pojoClass,methods,sysName));
        add(new CreateMergeDao(name,toolClass,pojoClass,methods,sysName));
        add(new CreateProperty(name,toolClass,pojoClass,methods,sysName));

    }
}
