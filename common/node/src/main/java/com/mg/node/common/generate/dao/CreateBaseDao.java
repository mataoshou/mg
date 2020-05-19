package com.mg.node.common.generate.dao;


import com.mg.common.iservice.ibasic.ICreate;
import com.mg.common.unit.ClassUnit;
import com.mg.common.unit.MethodUnit;

import java.io.File;
import java.io.IOException;

public class CreateBaseDao extends ICreate {


    public CreateBaseDao(String name) {
        super(name, null);
    }

    @Override
    public void startCreate() throws IOException {
        super.startCreate();
    }

    @Override
    protected void createPreMethod(ClassBuildUtil classBuildUtil) throws IOException {
        String mapperFileName = this.getName() + "Mapper";
        File daoFile = new File(this.getClassFile().getParent() ,mapperFileName+".java");

        String content = FileStore.getContent(daoFile, "UTF-8");
        content = content.replace(mapperFileName, this.getClassName());
        FileStore.putString(this.getClassFile(), content, "UTF-8");

        BaseFileUtil.delete(daoFile);
    }

    public void build()
    {

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
        return null;
    }

    @Override
    public String getClassName(String name) {
        return null;
    }
}
