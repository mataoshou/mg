package com.mg.common.genate.mgconvert;

import com.shineon.db.common.base.constant.convert.ConvertsConstant;
import com.shineon.db.common.base.util.ClassBuildUtil;
import com.shineon.db.common.create.ibase.ICreate;

import java.io.IOException;

public class CreateConvertUtil extends ICreate {
    public CreateConvertUtil(String actionName, Class toolClass, Class pojoClass, String[] methods, String sysName) {
        super(actionName, toolClass, pojoClass, methods, sysName);
    }

    @Override
    protected ClassBuildUtil createClass() throws IOException {
        ClassBuildUtil classBuildUtil = new ClassBuildUtil();

        String baseName = this.getName() + "CommonBase";

        classBuildUtil.classInit(this.getClassName(),baseName, null, this.getPackageName() ,new String[]{"Service"},true,
                String.format("%s.%s", ConvertsConstant.BASE_PACKAGE,baseName),"org.springframework.stereotype.Service");

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
        return ConvertsConstant.UTIL_PACKAGE;
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
        return "CommonUtil";
    }

    @Override
    protected String getConstantClassNameLast() {
        return null;
    }

}
