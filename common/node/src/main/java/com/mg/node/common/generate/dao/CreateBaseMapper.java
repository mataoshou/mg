package com.mg.node.common.generate.dao;

import com.shineon.db.common.base.constant.db.DBConstant;
import com.shineon.db.common.base.util.BaseFileUtil;
import com.shineon.db.common.base.util.ClassBuildUtil;
import com.shineon.db.common.base.util.FileStore;
import com.shineon.db.common.create.ibase.ICreate;

import java.io.File;
import java.io.IOException;

public class CreateBaseMapper extends ICreate {
    public CreateBaseMapper(String actionName, Class toolClass, Class pojoClass, String[] methods, String sysName) {
        super(actionName, toolClass, pojoClass, methods, sysName);
    }

    @Override
    protected ClassBuildUtil createClass() throws IOException {
        return null;
    }

    @Override
    protected void createPreMethod(ClassBuildUtil classBuildUtil) throws IOException {
        String mapperFileName = this.getName() + "Mapper";

        String mergeFileName = "I" + this.getName() + "Mapper";

        File mapperFile = new File(this.getClassFile().getParent(), mapperFileName + ".xml");
        String content = FileStore.getContent(mapperFile, "UTF-8");
        content = content.replace(mapperFileName, mergeFileName).replace("dao", "mergedao");
        FileStore.putString(this.getClassFile(), content, "UTF-8");

        BaseFileUtil.delete(mapperFile);
    }

    @Override
    protected void createMethod(ClassBuildUtil classBuildUtil, String methodName) throws IOException {

    }

    @Override
    protected void createLastMethod(ClassBuildUtil classBuildUtil) throws IOException {

    }

    @Override
    protected ClassBuildUtil createConstantClass() throws IOException {
        return null;
    }

    @Override
    protected void createConstantPreMethod(ClassBuildUtil classBuildUtil) throws IOException {

    }

    @Override
    protected void createConstantMethod(ClassBuildUtil classBuildUtil, String methodName) throws IOException {

    }

    @Override
    protected void classInit() {
        this.setConver(true);
    }

    @Override
    protected String getPackageName() {
        return DBConstant.DB_MAPPER_PACKAGE;
    }

    @Override
    protected boolean isCreateConstant() {
        return false;
    }


    @Override
    protected String getConstantPackageName() {
        return null;
    }

    @Override
    protected String getClassNameLast() {
        return "MapperBase";
    }

    @Override
    protected String getConstantClassNameLast() {
        return null;
    }

    @Override
    protected String getSuffix() {
        return "xml";
    }

}
