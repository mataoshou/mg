package com.mg.common.plugin.igenerate;

import com.mg.common.pojo.ParamItem;
import com.mg.common.util.StringUtil;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 创建 单元pojo
 */
public class CreateItem {


    //包名
    private String packageName;


    //对象名称
    private String name;


    //生成方法
    private String[] methods;


    //对象文件路径
    private File classFile;


    //是否覆盖原来的文件
    private boolean overwrite =true;


    //参数对象
    private Map<String, ParamItem> params = new HashMap<String,ParamItem>();




    public CreateItem(String name, String[] methods, String packageName)
    {

        StringUtil stringUtil = new StringUtil();
        this.name = stringUtil.firstUpper(name.trim());
        this.methods = methods;
        this.packageName = packageName.trim();


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


    public String[] getMethods() {
        return methods;
    }

    public void setMethods(String[] methods) {
        this.methods = methods;
    }


    public File getClassFile() {
        return classFile;
    }

    public void setClassFile(File classFile) {
        this.classFile = classFile;
    }


    public String getPackageName() {
        return packageName;
    }


    public void addParame(String name ,ParamItem value)
    {
        this.params.put(name,value);
    }

    public ParamItem getParam(String name)
    {
        return this.params.get(name);
    }

    public Map<String, ParamItem> getAllParams()
    {
        return this.params;
    }

}
