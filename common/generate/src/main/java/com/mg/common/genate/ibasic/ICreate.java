package com.mg.common.genate.ibasic;


import com.mg.common.util.BaseFileUtil;
import com.mg.common.util.ClassBuildUtil;
import com.mg.common.util.CommonTool;
import com.mg.common.util.FileStore;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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


    ////////////////////////////////////////////////////////模板函数


    public ICreate(String name, Class toolClass,
                   Class pojoClass, String[] methods, String sysName)
    {
        this.item = new CreateItem(name,toolClass,pojoClass,methods,sysName,getPackageName());
        item.setOverwrite(false);
        initSys();
        classInit();
    }


    /**
     * 初始化
     */
    private void initSys(){
        this.classFile = initFilePath(item.getPackageName(),getClassName());
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

        log.info("开始生成新对象!!");
        editClass(true);
        log.info("完成对象新生成!!");
    }

    /**
     * 开始对象的生成
     */
    public void startEdit() throws IOException {

        log.info("开始对象内容添加!!");
        editClass(false);
        log.info("完成对象内容添加!!");
    }

    /**
     * 检查是否结束初始化
     * @return
     */
    private boolean isFinishInit()
    {
        if(item.getPackageName()==null||item.getPackageName().length()<=0)
        {
            log.info("packageName未初始化，请设置packageName!!");
            return false;
        }

        if(!item.isOverwrite())
        {
            if(this.classFile.exists())
            {
                log.info("文件已存在:" + this.classFile.getPath());
                return false;
            }
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


    private String  getClassContent(String content){
        String reg = "\\{([\\w\\W]*)}";

        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find())
        {
            String hit = matcher.group(1);
            return hit.trim();
        }

        return  "";
    }


    private String getContent(File file) throws IOException {
        String content = FileStore.getContent(file);
        return getClassContent(content);
    }


    private void editClass(boolean isNew) throws IOException {
        ClassBuildUtil classBuildUtil = createClass();
        preEditClass(isNew,classBuildUtil);

        if(this.item.getMethods()!=null&&this.item.getMethods().length>0)
        {
            for (String method : this.item.getMethods()) {
                createMethod(classBuildUtil, method);
                classBuildUtil.addTabContent("\r");
            }
        }
        if(isNew) {
            createLastMethod(classBuildUtil);
        }

        //结束class 构建
        if(classBuildUtil!=null) {
            classBuildUtil.finish(this.classFile);
        }

    }


    private void preEditClass(boolean isNew, ClassBuildUtil classBuildUtil) throws IOException {
        if(classBuildUtil==null)
        {
            classBuildUtil = new ClassBuildUtil();
        }

        if(!isNew)
        {
            classBuildUtil.addTabContent(getContent(this.classFile));
            classBuildUtil.addTabContent("\r");
        }
        if(isNew) {
            createPreMethod(classBuildUtil);
            classBuildUtil.addTabContent("\r");
        }
    }


    public void empty()
    {
        BaseFileUtil.delete(this.classFile.getParentFile());
    }


    public String getName()
    {
        return item.getName();
    }

    public String getClassName()
    {
        return this.getClassNamePre() + item.getName() + this.getClassNameLast();
    }

    public String getClassFullName()
    {
        return this.getPackageName() +"."+ this.getClassNamePre() + item.getName() + this.getClassNameLast();
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
    protected abstract ClassBuildUtil createClass() throws IOException;


    /**
     * 构建文件
     */
    protected abstract void createPreMethod(ClassBuildUtil classBuildUtil) throws IOException;

    /**
     * 构建文件
     */
    protected abstract void createMethod(ClassBuildUtil classBuildUtil,String methodName) throws IOException;

    /**
     * 构建文件
     */
    protected abstract void createLastMethod(ClassBuildUtil classBuildUtil) throws IOException;


    /**
     * 初始化
     */
    protected  abstract void classInit();

    /**
     * 获取类的包名
     * @return
     */
    protected abstract String getPackageName();


    /**
     * 类名称 前缀
     * @return
     */
    protected String getClassNamePre(){
        return "";
    }


    /**
     * 类名称 后缀
     * @return
     */
    protected abstract String getClassNameLast();

}
