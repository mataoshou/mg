package com.mg.node.common.generate.dao;

import com.shineon.db.common.base.constant.db.DBConstant;
import com.shineon.db.common.base.constant.sys.SysConstant;
import com.shineon.db.common.base.util.BaseFileUtil;
import com.shineon.db.common.create.CommonTool;
import com.shineon.db.common.create.ibase.IFactory;

import java.io.File;

public class GeneratorFactory extends IFactory<GeneratorMakeUp> {


    public GeneratorFactory() {
        super("sql", null, null, null, null);
    }

    public GeneratorFactory(String name, Class toolClass, Class pojoClass, String[] methods, String sysName) {
        super(name, toolClass, pojoClass, methods, sysName);
    }

    @Override
    public GeneratorMakeUp setMakeUp(String name, Class toolClass, Class pojoClass, String[] methods, String sysName) {
        return new GeneratorMakeUp(name,null,null,null, SysConstant.getSys());
    }

    @Override
    public void build() throws Exception {
        CreatePojo createPojo = new CreatePojo();
        createPojo.createClass();

        CommonTool tool = new CommonTool();

        File pojoRoot = tool.getSysPath(DBConstant.DB_POJO_PACKAGE);

        File[] pojos = pojoRoot.listFiles();
        for(File pojo : pojos) {
            String name = BaseFileUtil.getFileNameNoSuffix(pojo.getName());
//            String pojoClassName = ConvertsConstant.POJO_PACKAGE +"." + name;
//            Class pojoClass = Class.forName(pojoClassName);
            GeneratorMakeUp makeUp = new GeneratorMakeUp(name,null,null,null, SysConstant.getSys());
            makeUp.build();
        }
    }
}
