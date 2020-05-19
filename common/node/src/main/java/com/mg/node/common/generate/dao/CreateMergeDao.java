package com.mg.node.common.generate.dao;

import com.shineon.db.common.base.constant.db.DBConstant;
import com.shineon.db.common.base.util.ClassBuildUtil;
import com.shineon.db.common.create.ibase.ICreate;

import java.io.IOException;

public class CreateMergeDao extends ICreate {
    public CreateMergeDao(String actionName, Class toolClass, Class pojoClass, String[] methods, String sysName) {
        super(actionName, toolClass, pojoClass, methods, sysName);
    }

    @Override
    protected ClassBuildUtil createClass() throws IOException {
        ClassBuildUtil classBuildUtil = new ClassBuildUtil();

        String mapperBaseFileName = this.getName() +"MapperBase";
        String mapperExternFileName = this.getName() +"MapperExtern";
        classBuildUtil.classInit(this.getClassName(), mapperBaseFileName + "," + mapperExternFileName,null, this.getPackageName(), null, false,
                DBConstant.DB_DAO_PACKAGE+"." + mapperBaseFileName, DBConstant.DB_DAO_PACKAGE+"." + mapperExternFileName);


        return classBuildUtil;
    }

    @Override
    protected void createPreMethod(ClassBuildUtil classBuildUtil) throws IOException {

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

    }

    @Override
    protected String getPackageName() {
        return DBConstant.DB_MERGEDAO_PACKAGE;
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
    protected String getClassNamePre() {
        return "I";
    }

    @Override
    protected String getClassNameLast() {
        return "Mapper";
    }

    @Override
    protected String getConstantClassNameLast() {
        return null;
    }

}
