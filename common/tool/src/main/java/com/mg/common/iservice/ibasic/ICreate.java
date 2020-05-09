package com.mg.common.iservice.ibasic;


import com.mg.common.pojo.LineItem;
import com.mg.common.unit.ClassUnit;
import com.mg.common.unit.MethodUnit;
import com.mg.common.util.BaseFileUtil;
import com.mg.common.util.CommonTool;
import com.mg.common.util.FileStore;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 单文件生成类
 */
@Slf4j
public abstract class ICreate {

    ////////////////////////////////////构造参数//////////////////////////////////

    private CreateItem item ;

    private File classFile;

    public CreateItem getItem() {
        return item;
    }

    public void setItem(CreateItem item) {
        this.item = item;
    }

    Map<String,Object> paramItems = new HashMap<>();

    //类构造工具
    private ClassUnit unit = new ClassUnit();



    ////////////////////////////////////////////////////////模板函数


    public ICreate(String name, String[] methods)
    {
        this.item = new CreateItem(name,methods,getPackageName());
        item.setOverwrite(false);

        unit.setName(getClassName(name));
        unit.setPackageName(getPackageName());


        initBegin();
        classInit(unit);
        initEnd();
    }

    public void addParamItem(String key,Object value)
    {
        paramItems.put(key,value);
    }


    /**
     * 初始化
     */
    private void initBegin(){
        log.info(String.format("开始初始化%s对象",item.getName()));
        this.classFile = initFilePath(item.getPackageName(),getClassName(item.getName()));
    }

    private void initEnd()
    {
        log.info(String.format("完成初始化%s对象",item.getName()));
    }

    /**
     * 开始对象的生成
     */
    public void startCreate() throws IOException {
        if(!checkBeforeBuild())
        {
            log.info("生成失败，checkBeforeBuild函数检查结果返回false，停止生成文件!!");
            return;
        }

        if(!isFinishInit())
        {
            log.info("系统初始化失败，请检查是否有参数未完成初始化或生成文件已存在，停止生成文件!!");
            return;
        }
        this.item.setOverwrite(true);
        log.info("开始生成新对象!!");
        editClass();
        log.info("完成对象新生成!!");
    }

    /**
     * 开始对象的生成
     */
    public void startEdit() throws IOException {

        this.item.setOverwrite(false);
        log.info("开始对象内容添加!!");
        editClass();
        log.info("完成对象内容添加!!");
    }

    /**
     * 检查是否结束初始化
     * @return
     */
    private boolean isFinishInit()
    {
        if(!item.isOverwrite()&&this.classFile.exists())
        {
            log.info("文件已存在:" + this.classFile.getPath());
            return false;
        }
        return true;
    }



    /**
     * 构建文件存放位置
     * @param packageName
     * @param fileName
     * @return
     */
    protected File initFilePath(String packageName,String fileName)
    {
        CommonTool tool = new CommonTool();

        File root = tool.getSysPath(packageName);
        if(!fileName.endsWith(getSuffix()))
        {
            fileName +="."+ getSuffix();
        }
        return new File(root,fileName);
    }

    /**
     * 文件后缀
     * @return
     */
    protected String getSuffix()
    {
        return "java";
    }



    /**
     * 删除已生成文件
     */
    public void deleteFile()
    {
        if(this.classFile.exists())
        {
            BaseFileUtil.delete(this.classFile);
        }

    }



    private void editClass() throws IOException {
        if(this.item.getMethods()!=null&&this.item.getMethods().length>0)
        {
            for (String method : this.item.getMethods()) {

                MethodUnit munit = new MethodUnit();
                munit.setName(method);
                createMethod(munit);
            }
        }

        //结束class 构建
        if(unit!=null) {
            finish(this.classFile);
        }

    }

    private void finish(File classFile)
    {
        FileStore.putString(classFile,unit.finish());
    }



    public void empty()
    {
        BaseFileUtil.delete(this.classFile.getParentFile());
    }


    public String getName()
    {
        return item.getName();
    }

    public String getClassFullName()
    {
        return this.getPackageName() +"."+ getClassName(item.getName());
    }


    public File getClassFile() {
        return classFile;
    }

    public void setClassFile(File classFile) {
        this.classFile = classFile;
    }


    public void setOverwrite(Boolean overwrite)
    {
        this.item.setOverwrite(overwrite);
    }

    /**
     * 生成前的检查
     * @return
     */
    protected boolean checkBeforeBuild(){
        return true;
    }

    //////////////////////////////////抽象函数////////////////////////////////////////


    /**
     * 构建文件
     */
    protected abstract void createPreMethod(ClassUnit unit) throws IOException;

    /**
     * 构建文件
     */
    protected abstract void createMethod(MethodUnit unit) throws IOException;


    /**
     * 初始化
     */
    protected  abstract void classInit(ClassUnit unit);

    /**
     * 获取类的包名
     * @return
     */
    protected abstract String getPackageName();

    public abstract String getClassName(String name);

}
