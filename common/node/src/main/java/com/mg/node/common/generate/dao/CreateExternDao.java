package com.mg.node.common.generate.dao;

import com.shineon.db.common.base.constant.db.DBConstant;
import com.shineon.db.common.base.util.ClassBuildUtil;
import com.shineon.db.common.create.ibase.ICreate;

import java.io.IOException;

public class CreateExternDao extends ICreate {
    public CreateExternDao(String actionName, Class toolClass, Class pojoClass, String[] methods, String sysName) {
        super(actionName, toolClass, pojoClass, methods, sysName);
    }

    @Override
    protected ClassBuildUtil createClass() throws IOException {
        ClassBuildUtil classBuildUtil = new ClassBuildUtil();
        classBuildUtil.classInit(this.getClassName(), "",null,this.getPackageName(), null, false,
                String.format("%s.%s", DBConstant.DB_POJO_PACKAGE, this.getName()), "java.util.List","org.apache.ibatis.annotations.Param");

        return classBuildUtil;


    }

    @Override
    protected void createPreMethod(ClassBuildUtil classBuildUtil) throws IOException {
        classBuildUtil.addTabContent("\r");
        classBuildUtil.addTabContent( String.format(" List<%s> list(@Param(\"where\") String where,@Param(\"order\") String order);", this.getName()));

        classBuildUtil.addTabContent("\r");
        classBuildUtil.addTabContent( String.format(" %s selectByName(String name);", this.getName()));
        classBuildUtil.addTabContent("\r");
        classBuildUtil.addTabContent( String.format(" %s get(@Param(\"where\") String where);", this.getName()));
        classBuildUtil.addTabContent("\r");
        classBuildUtil.addTabContent( String.format(" int insertByCustomId(%s item);", this.getName()));
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
        return DBConstant.DB_DAO_PACKAGE;
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
        return "MapperExtern";
    }

    @Override
    protected String getConstantClassNameLast() {
        return null;
    }


}
