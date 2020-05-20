package com.mg.node.common.generate.db;


import com.mg.common.iservice.ibasic.IMakeUpBase;

public class DBMakeUp extends IMakeUpBase {
    public DBMakeUp(String name) {
        add(new CreateBaseMapper(name));
        add(new CreateBaseMapperXML(name));
        add(new CreateExternMapper(name));
        add(new CreateExternMapperXML(name));
        add(new CreateMergeMapper(name));
        add(new CreateProperty(name));
    }
}
