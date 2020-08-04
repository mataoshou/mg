package com.mg.node.common.generate.db;

import com.mg.common.iservice.ibasic.ICreate;
import com.mg.common.unit.ClassUnit;
import com.mg.common.unit.MethodUnit;
import com.mg.common.util.DomUtil;
import com.mg.common.util.StringUtil;
import com.mg.node.common.config.DaoConfiguration;
import com.mg.node.common.constant.DBConstant;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CreateProperty extends ICreate {


    public CreateProperty(String name) {
        super(name, null);
    }



    @Override
    protected void createPre(ClassUnit unit) throws IOException {
        DaoConfiguration configuration = new DaoConfiguration();
        String tableName = configuration.daoUtilsBean().getTableName(this.getName());

        File baseMapperFile = new  File(this.getClassFile().getParentFile().getParentFile(),"/xml/"+this.getName() +"MapperBase.xml");

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


            unit.addPreContent(String.format("public static String %s = \"%s\";",propertyItem,tableName +"." +itemName));
            unit.addPreContent("\r");

        }
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
        return DBConstant.DB_PROPERTY_PACKAGE;
    }

    @Override
    public String getClassName(String name) {
        return StringUtil.firstUpper(name) +"Property";
    }


}
