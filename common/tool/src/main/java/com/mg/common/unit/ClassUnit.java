package com.mg.common.unit;

import com.mg.common.pojo.ClassItem;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ClassUnit {

    private ClassItem item = new ClassItem();


    String content = "";

    List<String> innerContent =  new ArrayList<>();


    public void init()
    {
        String content =template();

        content = content.replace("#packageName#",item.getPackageName())
                .replace("#import#",getImports(item.getImports()))
                .replace("#annotation#",getAnnotation(item.getAnnotations()))
                .replace("#classType#",getClassType(item.getType()))
                .replace("#className#",getClassName(item.getName(),item.getBaseName(),item.getImplementStringList()));

    }


    private String getImports(List<String> imports) {

        String importData = "";
        /////////添加import
        if (imports != null && imports.size() > 0) {
            for (String importName : imports) {
                importData += String.format("import %s;", importName);
            }
        }
        return importData;
    }

    private String getAnnotation(List<String> annotation) {
        String annotationData = "";

        if (annotation != null && annotation.size() > 0) {
            for (String str : annotation) {
                annotationData += String.format("@%s", str);
            }

        }
        return annotationData;
    }


    private String getClassType( int type) {
        ////////构建class内容
        String classType = "class";
        if (type==2) {
            classType = "interface";
        }

        return classType;
    }

    private String getClassName(String className ,String baseName,List<String> imps)
    {
        String classNameData =className;
        if(className!=null&&baseName.length()>0) {
            classNameData = String.format("%s extends %s ", className, baseName);
        }

        if(imps!=null&&imps.size()>0)
        {
            classNameData +="implements ";
            for(int i=0;i< imps.size();i++)
            {
                if(i!=0) {
                    classNameData += ",";
                }
                classNameData+=imps.get(i);
            }
        }

        return classNameData;
    }


    /**
     * 完成 并返回class文本内容
     * @return
     */
    public String finish()
    {
        if(innerContent==null||innerContent.size()==0)
        {
            return "";

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
