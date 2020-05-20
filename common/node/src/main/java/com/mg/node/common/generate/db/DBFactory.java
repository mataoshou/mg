package com.mg.node.common.generate.db;

import com.mg.common.iservice.ibasic.IFactory;
import com.mg.common.util.BaseFileUtil;
import com.mg.common.util.CommonTool;
import com.mg.node.common.constant.DBConstant;

import java.io.File;

public class DBFactory extends IFactory {


    @Override
    public void build() throws Exception {
        CreatePojo createPojo = new CreatePojo();
        createPojo.createClass();

        CommonTool tool = new CommonTool();

        File pojoRoot = tool.getSysPath(DBConstant.DB_POJO_PACKAGE);

        File[] pojos = pojoRoot.listFiles();
        for(File pojo : pojos) {
            String name = BaseFileUtil.getFileNameNoSuffix(pojo.getName());
            DBMakeUp makeUp = new DBMakeUp(name);
            makeUp.build();
        }
    }
}
