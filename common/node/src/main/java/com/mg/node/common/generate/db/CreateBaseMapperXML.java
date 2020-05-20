package com.mg.node.common.generate.db;

import com.mg.common.iservice.ibasic.ICreate;
import com.mg.common.unit.ClassUnit;
import com.mg.common.unit.MethodUnit;
import com.mg.common.util.BaseFileUtil;
import com.mg.common.util.FileStore;
import com.mg.common.util.StringUtil;
import com.mg.node.common.constant.DBConstant;

import java.io.File;
import java.io.IOException;

public class CreateBaseMapperXML extends ICreate {


    public CreateBaseMapperXML(String name) {
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
        String mapperFileName = this.getName2() + "Mapper";

        String mergeFileName = "I" + this.getName2() + "Mapper";

        File mapperFile = new File(this.getClassFile().getParent(), mapperFileName + ".xml");
        String content = FileStore.getContent(mapperFile, "UTF-8");
        content = content.replace(mapperFileName, mergeFileName).replace("dao", "mergedao");
        FileStore.putString(this.getClassFile(), content, "UTF-8");

        BaseFileUtil.delete(mapperFile);
    }


    @Override
    protected String getSuffix() {
        return "xml";
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
        return DBConstant.DB_XML_MAPPER_PACKAGE;
    }

    @Override
    public String getClassName(String name) {
        return StringUtil.firstUpper(name) +"MapperBase";
    }

}
