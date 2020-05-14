package com.mg.common.unit;

import com.mg.common.pojo.ClassItem;
import com.mg.common.pojo.LineItem;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class ClassUnit {

    private ClassItem item = new ClassItem();


    String content = "";

    List<MethodUnit> methods =  new ArrayList<>();

    List<LineItem> lines = new ArrayList<>();


    public void init()
    {
        content =template();

        content = content.replace("#packageName#",item.getPackageName())
                .replace("#import#",getImports(item.getImports()))
                .replace("#annotation#",getAnnotation(item.getAnnotations()))
                .replace("#classType#",getClassType(item.getType()))
                .replace("#className#",getClassName(item.getName(),item.getBaseName(),item.getImplementStringList()));
    }
    public void setName(String name) {
        this.item.setName(name);
    }

    public String getName()
    {
        return this.item.getName();
    }

    public void setPackageName(String packageName) {
        this.item.setPackageName(packageName);
    }

    public void setBaseName(String baseName) {
        this.item.setBaseName(baseName);
    }

    public void setType(int type){
        this.item.setType(type);
    }

    public ClassUnit addImport(String imp)
    {
        this.item.addImport(imp);
        return this;
    }

    public void addImplement(String imp)
    {
        this.item.addImpelement(imp);
    }

    public void addPreContent(String content)
    {
        LineItem lineItem = new LineItem();
        lineItem.setContent(content);
        lineItem.setIntervalNo(1);
        lines.add(lineItem);
    }

    public ClassUnit addImport(String[] imps)
    {
        for(String imp : imps) {
            this.item.addImport(imp);
        }
        return this;
    }

    public ClassUnit addAnnotion(String ann)
    {
        this.item.addAnnotation(ann);
        return this;
    }

    private String getImports(List<String> imports) {

        String importData = "";
        /////////添加import
        if (imports != null && imports.size() > 0) {
            for (String importName : imports) {
                importData += String.format("import %s;\n", importName);
            }
        }
        return importData;
    }

    private String getAnnotation(List<String> annotation) {
        String annotationData = "";

        if (annotation != null && annotation.size() > 0) {
            for (String str : annotation) {
                if(annotationData!=null&&annotationData.length()>0)
                {
                    annotationData += "\n";
                }
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
        if(baseName!=null&&baseName.length()>0) {
            classNameData = String.format("%s extends %s ", className, baseName);
        }

        if(imps!=null&&imps.size()>0)
        {
            classNameData +=" implements ";
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

        if(content==null||content.length()==0) {
            init();
        }
        String preConent ="";
        for(LineItem lineItem : lines)
        {
            preConent += lineItem.buildContent() ;
        }
        content = content.replace("#preContent#",preConent);

//        if(methods==null||methods.size()==0)
//        {
////            return "";
//
//        }

        String methodStr ="";
        for(MethodUnit unit : methods)
        {
            methodStr += unit.getPre();
            methodStr += unit.getContent();
        }
        content = content.replace("#methods#",methodStr);
        return content;
    }


//    /**
//     * 完成 并将内容写入文件
//     * @return
//     */
//    public void finish(File file) throws IOException {
//        finish();
//        log.info("开始生成文件：" + file.getPath());
//        file.getParentFile().mkdirs();
//        FileOutputStream out = new FileOutputStream(file);
//        out.write(content.getBytes("UTF-8"));
//        out.close();
//        log.info("文件生成成功！！");
//    }


    public void editClass(String content)
    {
        String body = getClassContent(content);
        this.content = content.replace(body,body+"\r\n#methods#");
    }



    public String template()
    {
        String classTemplate =
                "package #packageName# " +"\r\n\r\n"+
                        "#import#"+"\r\n"+
                        "#annotation#"+"\r\n"+
                        "public #classType# #className# {" +"\r\n"+
                        "#preContent#"+"\r\n"+
                        "#methods#"+"\r\n"+
                        "}\n";
        return classTemplate;
    }





    public MethodUnit createMethod(String name)
    {
        MethodUnit unit = new MethodUnit();
        unit.setName(name);

        return unit;
    }

    public void addMethod(MethodUnit unit)
    {
        this.methods.add(unit);
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


}
