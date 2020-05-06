package com.mg.common.pojo;

import java.util.ArrayList;
import java.util.List;

public class ClassItem {
    /**
     * 名称
     */
    private String name;
    /**
     *包名
     */
    private String packageName;
    /**
     * 引入
     */
    private List<String> imports = new ArrayList();
    /**
     * 父类
     */
    private String baseName ;
    /**
     * 注解
     */
    private List<String> annotations = new ArrayList<>();
    /**
     * 引入接口
     */
    private List<String> implementStringList  = new ArrayList<>();


    /**
     * 文件类型  1 class  2 接口
     */
    private int type =1 ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public List<String> getImports() {
        return imports;
    }

    public void setImports(List<String> imports) {
        this.imports = imports;
    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

    public List<String> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(List<String> annotations) {
        this.annotations = annotations;
    }

    public List<String> getImplementStringList() {
        return implementStringList;
    }

    public void setImplementStringList(List<String> implementStringList) {
        this.implementStringList = implementStringList;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void addImpelement(String value)
    {
        this.implementStringList.add(value);
    }

    public void addImport(String value)
    {
        this.imports.add(value);
    }

    public  void addAnnotation(String value)
    {
        this.annotations.add(value);
    }

}
