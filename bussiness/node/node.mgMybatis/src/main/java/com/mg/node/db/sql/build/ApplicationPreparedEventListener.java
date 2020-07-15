//package com.mg.node.db.sql.build;
//
//import com.itranswarp.compiler.JavaStringCompiler;
//import org.springframework.boot.context.event.ApplicationPreparedEvent;
//import org.springframework.context.ApplicationListener;
//import org.springframework.core.OverridingClassLoader;
//
//import java.io.IOException;
//import java.util.Map;
//
//public class ApplicationPreparedEventListener implements ApplicationListener<ApplicationPreparedEvent> {
//    @Override
//    public void onApplicationEvent(ApplicationPreparedEvent event) {
//        ClassLoader appClassLoader = Thread.currentThread().getContextClassLoader();
//        OverridingClassLoader overridingClassLoader = new OverridingClassLoader(appClassLoader);
////        overridingClassLoader.loadClass()
//    }
//
//
//
//
//    public Class getAddClass() throws IOException, ClassNotFoundException {
//        // 声明类名
//        String className = "MgSample";
//        String packageName = "mg.demo";
//        // 声明包名：package top.fomeiherz;
//        String prefix = String.format("package %s;", packageName);
//        // 全类名：top.fomeiherz.Main
//        String fullName = String.format("%s.%s", packageName, className);
//
//        // 传入String类型的代码
//        String source = "public class MgSample" +
//                "{" +
//                "public static void main(String[] args) {" +
//                "System.out.println(\"...................mgDemoTest\");" +
//                "}" +
//                "}";
//
//        JavaStringCompiler compiler = new JavaStringCompiler();
//        System.out.println(prefix + source);
//        // 编译：compiler.compile("Main.java", source)
//        Map<String, byte[]> results = compiler.compile(className + ".java", prefix + source);
//        // 加载内存中byte到Class<?>对象
//        Class<?> clazz = compiler.loadClass(fullName, results);
//        return clazz;
//    }
//}
