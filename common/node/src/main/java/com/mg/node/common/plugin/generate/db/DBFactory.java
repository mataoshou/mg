package com.mg.node.common.plugin.generate.db;

import com.mg.common.plugin.igenerate.IFactory;

public class DBFactory extends IFactory {


    @Override
    public void build() throws Exception {
        CreatePojo createPojo = new CreatePojo();
        createPojo.createClass();

//        CommonTool tool = new CommonTool();
//
//        File pojoRoot = tool.getSysPath(DBConstant.DB_POJO_PACKAGE);
//
//        File[] pojos = pojoRoot.listFiles();
//        for(File pojo : pojos) {
//            String name = BaseFileUtil.getFileNameNoSuffix(pojo.getName());
//            DBMakeUp makeUp = new DBMakeUp(name);
//            makeUp.build();
//        }
    }
}
