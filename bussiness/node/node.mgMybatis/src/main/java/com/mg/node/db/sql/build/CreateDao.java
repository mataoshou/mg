package com.mg.node.db.sql.build;

import com.itranswarp.compiler.JavaStringCompiler;
import tk.mybatis.mapper.common.BaseMapper;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class CreateDao {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        // 声明类名
        String className = "RmtActiorInfoBaseMapperDao";
        String prefix = String.format("package com.mg.node.db.sql.mapper;");
        // 全类名：top.fomeiherz.Main
        String fullName = "com.mg.node.db.sql.mapper.RmtActiorInfoBaseMapperDao";


        // 传入String类型的代码
        String source = "public class RmtActiorInfoBaseMapperDao" +
                "{" +
                "public static void main(String[] args) {" +
                "System.out.println(\"...................mgDemoTest\");" +
                "}" +
                "}";

        // 编译器
        JavaStringCompiler compiler = new JavaStringCompiler();
        System.out.println(prefix + source);
        // 编译：compiler.compile("Main.java", source)
        Map<String, byte[]> results = compiler.compile(className + ".java", prefix + source);
        // 加载内存中byte到Class<?>对象
        Class<?> clazz = compiler.loadClass(fullName, results);
        System.out.println(clazz.getName());
        // 创建实例
        Object instance = clazz.newInstance();
        Method mainMethod = clazz.getMethod("main", String[].class);
        // String[]数组时必须使用Object[]封装
        // 否则会报错：java.lang.IllegalArgumentException: wrong number of arguments
        mainMethod.invoke(instance, new Object[]{args});
    }
}
