package com.mg.common.genate.mgconvert;


import com.mg.common.genate.ibasic.IFactory;
import com.mg.common.util.BaseFileUtil;
import com.mg.common.util.CommonTool;

import java.io.File;

public class ConvertFactory extends IFactory<ConvertMakeUp> {


    public ConvertFactory() {
        super("convert", null, null, null, null);
    }

    public ConvertFactory(String name, Class toolClass, Class pojoClass, String[] methods, String sysName) {
        super(name, toolClass, pojoClass, methods, sysName);
    }

    @Override
    public ConvertMakeUp setMakeUp(String name, Class toolClass, Class pojoClass, String[] methods, String sysName) {
        return new ConvertMakeUp(name,null,pojoClass,null, SysConstant.getSys());
    }

    @Override
    public void build() throws Exception {
        CommonTool tools = new CommonTool();
        File root = tools.getSysPath(ConvertsConstant.POJO_PACKAGE);
        File[] pojos = root.listFiles();

        for(File pf :pojos) {
            String fname = BaseFileUtil.getFileNameNoSuffix(pf.getName());
            String pojoClassName = ConvertsConstant.POJO_PACKAGE +"." + fname;
            Class pojoClass = Class.forName(pojoClassName);
            ConvertMakeUp makeUp = new ConvertMakeUp(fname,null,pojoClass,null, SysConstant.getSys());
            makeUp.build();
        }
    }

    @Override
    public void rebuild() throws Exception {
        build();
    }

}
