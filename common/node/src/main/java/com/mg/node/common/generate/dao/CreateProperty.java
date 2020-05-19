package com.mg.node.common.generate.dao;

import com.shineon.db.common.base.constant.db.DBConstant;
import com.shineon.db.common.base.util.ClassBuildUtil;
import com.shineon.db.common.base.util.DomUtil;
import com.shineon.db.common.create.ibase.ICreate;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CreateProperty extends ICreate {
    public CreateProperty(String actionName, Class toolClass, Class pojoClass, String[] methods, String sysName) {
        super(actionName, toolClass, pojoClass, methods, sysName);
    }

    @Override
    protected ClassBuildUtil createClass() throws IOException {

        ClassBuildUtil classBuildUtil = new ClassBuildUtil();

        classBuildUtil.classInit(this.getClassName(), null,null, this.getPackageName(), null, true, null);

        return classBuildUtil;

    }

    @Override
    protected void createPreMethod(ClassBuildUtil classBuildUtil) throws IOException {
        String tableName = GeneratorUtils.getTableName(this.getName());

        File baseMapperFile = new  File(this.getClassFile().getParentFile().getParentFile(),"/mapper/"+this.getName() +"MapperBase.xml");

        DomUtil domUtil = new DomUtil();
        Document document = null;
        try {
            document = domUtil.getDocument(baseMapperFile);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        Element element = document.getRootElement().element("resultMap");

        List<Element> eles = element.elements();

        for (Element ele : eles) {
            String itemName = ele.attributeValue("column");
            String propertyItem = itemName +"Property";


            classBuildUtil.addTabContent(String.format("public static String %s = \"%s\";",propertyItem,tableName +"." +itemName));
            classBuildUtil.addTabContent("\r");

        }


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
        return DBConstant.DB_PROPERTY_PACKAGE;
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
        return "Property";
    }

    @Override
    protected String getConstantClassNameLast() {
        return null;
    }
}
