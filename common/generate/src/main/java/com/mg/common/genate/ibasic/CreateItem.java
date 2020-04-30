package com.mg.common.genate.ibasic;

import com.mg.common.util.StringUtil;

import java.io.File;

public class CreateItem {

    //包名
    private String packageName;

    //对象名称
    private String name;

    //工具类
    private Class toolClass;

    //pojo类
    private Class pojoClass;

    //生成方法
    private String[] methods;

    //系统名称
    private String sysName;

    //对象文件路径
    private File classFile;

    //POJO的类名
    private String pojoClassName;

    //工具类类名
    private String toolClassName;

    //POJO的类名
    private String pojoClassFullName;

    //工具类类名
    private String toolClassFullName;

    //是否覆盖原来的文件
    private boolean overwrite;



    public CreateItem(String name, Class toolClass,
                      Class pojoClass, String[] methods, String sysName, String packageName)
    {

        StringUtil stringUtil = new StringUtil();
        this.name = stringUtil.firstUpper(name.trim());
        this.toolClass = toolClass;
        this.pojoClass= pojoClass;
        this.methods = methods;
        this.sysName = sysName.trim();
        this.packageName = packageName.trim();

        if(pojoClass!=null) {
            this.pojoClassName = pojoClass.getSimpleName().trim();
            this.pojoClassFullName = pojoClass.getName();
        }
        if(toolClass!=null) {
            this.toolClassName = toolClass.getSimpleName().trim();
            this.toolClassFullName = toolClass.getName();
        }

    }


    public boolean isOverwrite() {
        return overwrite;
    }

    public void setOverwrite(boolean overwrite) {
        this.overwrite = overwrite;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class getToolClass() {
        return toolClass;
    }

    public void setToolClass(Class toolClass) {
        this.toolClass = toolClass;
    }

    public Class getPojoClass() {
        return pojoClass;
    }

    public void setPojoClass(Class pojoClass) {
        this.pojoClass = pojoClass;
    }

    public String[] getMethods() {
        return methods;
    }

    public void setMethods(String[] methods) {
        this.methods = methods;
    }

    public String getSysName() {
        return sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName;
    }

    public File getClassFile() {
        return classFile;
    }

    public void setClassFile(File classFile) {
        this.classFile = classFile;
    }

    public String getPojoClassName() {
        return pojoClassName;
    }

    public void setPojoClassName(String pojoClassName) {
        this.pojoClassName = pojoClassName;
    }

    public String getToolClassName() {
        return toolClassName;
    }

    public void setToolClassName(String toolClassName) {
        this.toolClassName = toolClassName;
    }

    public String getPackageName() {
        return packageName;
    }

    public String getPojoClassFullName() {
        return pojoClassFullName;
    }

    public void setPojoClassFullName(String pojoClassFullName) {
        this.pojoClassFullName = pojoClassFullName;
    }

    public String getToolClassFullName() {
        return toolClassFullName;
    }

    public void setToolClassFullName(String toolClassFullName) {
        this.toolClassFullName = toolClassFullName;
    }
}
