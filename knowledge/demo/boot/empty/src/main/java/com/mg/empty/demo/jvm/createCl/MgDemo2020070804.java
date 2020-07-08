package com.mg.empty.demo.jvm.createCl;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

public class MgDemo2020070804 {
    public static void main(String[] args) throws ClassNotFoundException {
        Map<String, byte[]> results = null;
        // 声明类名
        String className = "MgSample";
        String packageName = "mg.demo";
        String prefix = String.format("package %s;", packageName);
        // 全类名：top.fomeiherz.Main
        String fullName = String.format("%s.%s", packageName, className);

        // 传入String类型的代码
        String source = prefix +"public class MgSample" +
                "{" +
                "public static void main(String[] args) {" +
                "System.out.println(\"...................mgDemoTest\");" +
                "}" +
                "}";

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager stdManager = compiler.getStandardFileManager(null, null, null);
        try (MemoryJavaFileManager manager = new MemoryJavaFileManager(stdManager)) {
            JavaFileObject javaFileObject = manager.makeStringSource(className+".java", source);
            JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, Arrays.asList(javaFileObject));
            if (task.call()) {
                results = manager.getClassBytes();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        MemoryClassLoader classLoader = new MemoryClassLoader(results);
        Class cl = classLoader.findClass("mg.demo.MgSample");
        System.out.println(cl.getName());
    }
}
