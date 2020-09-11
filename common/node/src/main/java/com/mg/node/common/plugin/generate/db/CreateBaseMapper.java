package com.mg.node.common.plugin.generate.db;


import com.mg.common.plugin.igenerate.ICreate;
import com.mg.common.unit.ClassUnit;
import com.mg.common.unit.MethodUnit;
import com.mg.common.util.BaseFileUtil;
import com.mg.common.util.FileStore;
import com.mg.node.common.constant.DBConstant;

import java.io.File;
import java.io.IOException;

public class CreateBaseMapper extends ICreate {


    public CreateBaseMapper(String name) {
        super(name, null);
    }

    @Override
    public void startCreate() throws IOException {
        build();
    }


    @Override
    public void startEdit() throws IOException {
        build();
    }



    public void build() throws IOException {
        String mapperFileName =  this.getName2() + "Mapper";
        File daoFile = new File(this.getClassFile().getParent() ,mapperFileName+".java");

        String content = FileStore.getContent(daoFile, "UTF-8");
        content = content.replace(mapperFileName, this.getClassName(this.getName()));
        FileStore.putString(this.getClassFile(), content, "UTF-8");

        BaseFileUtil.delete(daoFile);
    }

    @Override
    protected void createPre(ClassUnit unit) throws IOException {

    }

    @Override
    protected void createPreEachMethod(MethodUnit munit) throws IOException {

    }

    @Override
    protected void createMethod(MethodUnit unit) throws IOException {

    }

    @Override
    protected void classInit(ClassUnit unit) {

    }

    @Override
    protected String getPackageName() {
        return DBConstant.DB_MAPPER_PACKAGE;
    }

    @Override
    public String getClassName(String name) {
        return name +"BaseMapper" ;
    }
}
