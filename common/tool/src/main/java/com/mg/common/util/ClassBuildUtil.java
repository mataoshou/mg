package com.mg.common.util;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Slf4j
public class ClassBuildUtil {

    int tab_no=0;
    String tab ="	";

    String classConetent;

//    List<MethodUtil> method_list = new ArrayList();


    public void classInit(String className,String packageName,boolean isclass,String... imports)
    {
        classInit(className,null,null,packageName,null,isclass,imports);
    }

    /**
     * 初始化class类
     * @param className  类名
     * @param baseName 接口和父类
     * @param packageName 包名
     * @param annotation 注解
     * @param isclass 是否为class  false 为接口
     * @param imports  import内容
     */
    public void classInit(String className,String baseName,String[] imps,String packageName,String[] annotation,boolean isclass,String... imports)
    {
        log.info(String.format("开始构建类文件 %s 的 文件内容",className));

        String content =template();

        content = content.replace("#packageName#",packageName)
                .replace("#import#",getImports(imports))
                .replace("#annotation#",getAnnotation(annotation))
                .replace("#classType#",getClassType(isclass))
                .replace("#className#",getClassName(className,baseName,imps));

        classConetent = content;

        tab_no++;
    }


    private String getImports(String[] imports) {

        String importData = "";
        /////////添加import
        if (imports != null && imports.length > 0) {
            for (String importName : imports) {
                importData += getContent(tab_no, tab, String.format("import %s;", importName));
            }
        }
        return importData;
    }

    private String getAnnotation(String[] annotation) {
        String annotationData = "";

        if (annotation != null && annotation.length > 0) {
            for (String str : annotation) {
                annotationData += getContent(tab_no, tab, String.format("@%s", str));
            }

        }
        return annotationData;
    }


    private String getClassType( boolean isclass) {
        ////////构建class内容
        String classType = "class";
        if (!isclass) {
            classType = "interface";
        }

        return classType;
    }

    private String getClassName(String className ,String baseName,String[] imps)
    {
        String classNameData =className;
        if(className!=null&&baseName.length()>0) {
            classNameData = String.format("%s extends %s ", className, baseName);
        }

        if(imps!=null&&imps.length>0)
        {
            classNameData +="implements ";
            for(int i=0;i< imps.length;i++)
            {
                if(i!=0) {
                    classNameData += ",";
                }
                classNameData+=imps[i];
            }
        }

        return classNameData;
    }



    String innerContent = "";


    /**
     * 完成 并返回class文本内容
     * @return
     */
    public String finish()
    {
        if(innerContent==null||innerContent.length()==0)
        {
            innerContent ="";

        }

        classConetent = classConetent.replace("#content#",innerContent);
        return classConetent;
    }
    /**
     * 完成 并将内容写入文件
     * @return
     */
    public void finish(File file) throws IOException {
        finish();
        log.info("开始生成文件：" + file.getPath());
        file.getParentFile().mkdirs();
        FileOutputStream out = new FileOutputStream(file);
        out.write(classConetent.getBytes("UTF-8"));
        out.close();
        log.info("文件生成成功！！");
    }


    /**
     * tab 间隔不变  增加类内容
     * @param line
     */
    public void  addTabContent(String line)
    {
        innerContent += getContent(tab_no,tab,line);
    }


    /**
     * tab 间隔加1  增加类内容
     * @param line
     */
    public void addTabRightContent(String line)
    {
        tab_no++;

        addTabContent(line);
    }
    /**
     * tab 间隔减1  增加类内容
     * @param line
     */
    public void addTabLeftContent(String line)
    {
        tab_no--;

        addTabContent(line);
    }


    private String getContent(int tab_no,String tab,String content)
    {
        String tabs="";
        for(int i=0;i<tab_no;i++)
        {
            tabs+=tab;
        }
        return tabs+content+"\r";
    }

    public String template()
    {
        String classTemplate =
                        "package #packageName# " +"\r\n"+
                        "#import#"+"\r\n"+
                        "#annotation#"+"\r\n"+
                        "public #classType# #className# {" +"\r\n"+
                        "#content#"+"\r\n"+
                        "}\n";

        return classTemplate;

    }

}
