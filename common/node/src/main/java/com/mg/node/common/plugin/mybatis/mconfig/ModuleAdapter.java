package com.mg.node.common.plugin.mybatis.mconfig;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.util.List;

public class ModuleAdapter extends PluginAdapter {
    @Override
    public boolean validate(List<String> list) {
        return true;
    }

    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        topLevelClass.addImportedType("lombok.Data");
        topLevelClass.addImportedType("com.mg.node.common.plugin.mybatis.annotations.Column");
        topLevelClass.addImportedType("com.mg.node.common.plugin.mybatis.annotations.PrimaryId");
        topLevelClass.addImportedType("com.mg.node.common.plugin.mybatis.annotations.Table");

        topLevelClass.addAnnotation("@Data");
        topLevelClass.addAnnotation(String.format("@Table(\"%s\")",introspectedTable.getFullyQualifiedTable()));

        return true;
    }


    @Override
    public boolean modelFieldGenerated(Field field, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        if(introspectedColumn.isIdentity())
        {
            field.addAnnotation("@PrimaryId");
        }
//        if(!field.getName().equals(introspectedColumn.getActualColumnName())) {
            field.addAnnotation(String.format("@Column(cloumn= \"%s\")", introspectedColumn.getActualColumnName()));
//        }

        return true;
    }



    /**
     *不添加set方法
     */
    @Override
    public boolean modelSetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        return false;
    }

    /**
     *不添加get方法
     */
    @Override
    public boolean modelGetterMethodGenerated(Method method, TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        return false;
    }
}
