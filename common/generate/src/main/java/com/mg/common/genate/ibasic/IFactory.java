package com.mg.common.genate.ibasic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class IFactory {

    List<IMakeUpBase> makeList = new ArrayList();

    public abstract T setMakeUp(String name, Class toolClass,
                                   Class pojoClass, String[] methods, String sysName);

    public IFactory(String name, Class toolClass,
                    Class pojoClass, String[] methods, String sysName)
    {
        makeList.add(setMakeUp(name, toolClass,
                pojoClass,methods, sysName));
    }

    public void addMakeUp()
    {

    }



    public void build() throws Exception{
        for(IMakeUpBase base : makeList) {
            base.build();
        }
    }

    public void delete() throws Exception{
        for(IMakeUpBase base : makeList) {
            base.delete();
        }
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
