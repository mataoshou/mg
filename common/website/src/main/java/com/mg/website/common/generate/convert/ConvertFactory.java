package com.mg.website.common.generate.convert;

import com.shineon.db.common.base.constant.convert.ConvertsConstant;
import com.shineon.db.common.base.constant.sys.SysConstant;
import com.shineon.db.common.base.util.BaseFileUtil;
import com.shineon.db.common.create.CommonTool;
import com.shineon.db.common.create.ibase.IFactory;

import java.io.File;

public class ConvertFactory extends IFactory<com.shineon.db.common.create.convert.ConvertMakeUp> {


    public ConvertFactory() {
        super("convert", null, null, null, null);
    }

    public ConvertFactory(String name, Class toolClass, Class pojoClass, String[] methods, String sysName) {
        super(name, toolClass, pojoClass, methods, sysName);
    }

    @Override
    public com.shineon.db.common.create.convert.ConvertMakeUp setMakeUp(String name, Class toolClass, Class pojoClass, String[] methods, String sysName) {
        return new com.shineon.db.common.create.convert.ConvertMakeUp(name,null,pojoClass,null, SysConstant.getSys());
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
            com.shineon.db.common.create.convert.ConvertMakeUp makeUp = new com.shineon.db.common.create.convert.ConvertMakeUp(fname,null,pojoClass,null, SysConstant.getSys());
            makeUp.build();
        }
    }

    @Override
    public void rebuild() throws Exception {
        build();
    }

}
