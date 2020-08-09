package com.mg.empty.demo.jvm.classload;

import com.itranswarp.compiler.JavaStringCompiler;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
public class MgClassLoadTool {

    protected String getClassTemplate() {
        String templateStr =
                "package com.mg.classload; " +"\r\n"+
                        "#import#"+"\r\n"+
                        "public class #className# implements com.mg.empty.demo.jvm.classload.IMethodExec{" +"\r\n"+
                        "#methods#"+"\r\n"+
                        "}\n";

        return templateStr;
    }

    protected String getmethodTemplate()
    {
        String templateStr =
                        "public void execute() throws Exception{" +"\r\n"+
                        "#content#"+
                        "   }\n";

        return templateStr;
    }

    List<String> codeLines =new ArrayList<>();
    List<Class> importLines = new ArrayList();

    public void addCode(String code)
    {
        codeLines.add(code);
    }

    public void addImport(Class cl)
    {
        importLines.add(cl);
    }


    public void excute() throws Exception {
        getObject().execute();
    }

    public IMethodExec getObject() throws IllegalAccessException, InstantiationException {
        return (IMethodExec) mgCl.newInstance();
    }

    public void build() throws IOException, ClassNotFoundException {
        String classTemplate = getClassTemplate();

        String methodTemplate = getmethodTemplate();

        String methodContent ="";

        for(String code : codeLines)
        {
            methodContent+=code;
            if(!code.endsWith(";"))
            {
                methodContent+=";";
            }
            methodContent+="\r\n";
        }

        String methodStr = methodTemplate.replace("#content#",methodContent);

        String imports ="";

        for(Class impCl : importLines)
        {
            imports += String.format("import %s;\n", impCl.getName());
        }
        String className = "MgMethodExec" + System.currentTimeMillis();
        String fullName= "com.mg.classload." +className;
        String classStr =classTemplate.replace("#import#",imports)
        .replace("#className#",className)
        .replace("#methods#",methodStr);

        log.info(classStr);
        
        JavaStringCompiler compiler = new JavaStringCompiler();
        // 编译：compiler.compile("Main.java", source)
        Map<String, byte[]> results = compiler.compile(className + ".java", classStr);
        // 加载内存中byte到Class<?>对象
        Class<?> clazz = compiler.loadClass(fullName, results);
        mgCl = clazz;
    }

    public Class mgCl =null;

    public static void main(String[] args) throws Exception {
        MgClassLoadTool tool = new MgClassLoadTool();
        tool.addCode("System.out.println(\"mg execute\")");

        tool.build();

        tool.excute();

    }


}
