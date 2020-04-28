package com.mg.common.genate.ibasic;

import java.io.IOException;

public abstract class IFactory<T extends IMakeUpBase> {

    T t;

    public abstract T setMakeUp(String name, Class toolClass,
                                   Class pojoClass, String[] methods, String sysName);

    public IFactory(String name, Class toolClass,
                    Class pojoClass, String[] methods, String sysName)
    {
        t = setMakeUp(name, toolClass,
                pojoClass,methods, sysName);
    }



    public void build() throws Exception{
        t.build();
    }

    public void delete() throws Exception{
        t.delete();
    }

    public void rebuild() throws Exception{
        t.rebuild();
    }

    public void edit() throws IOException {
        t.edit();
    }

    public void empty() throws IOException {
        t.empty();
    }
}
