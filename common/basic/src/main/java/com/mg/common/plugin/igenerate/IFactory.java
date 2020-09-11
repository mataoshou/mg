package com.mg.common.plugin.igenerate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class IFactory {

    List<IMakeUpBase> makeList = new ArrayList();


    public void addMakeUp(IMakeUpBase makeUpBase)
    {
        makeList.add(makeUpBase);
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
        for(IMakeUpBase base : makeList) {
            base.rebuild();
        }
    }

    public void edit() throws IOException {
        for(IMakeUpBase base : makeList) {
            base.edit();
        }
    }

    public void empty() throws IOException {
        for(IMakeUpBase base : makeList) {
            base.empty();
        }
    }
}
