package com.mg.empty.demo.jvm.createCl;

import groovy.lang.GroovyClassLoader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;

public class MgDemo2020070802 {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException {
        GroovyClassLoader groovyClassLoader = new GroovyClassLoader();
        //里面的文本是Java代码,但是我们可以看到这是一个字符串我们可以直接生成对应的Class<?>对象,而不需要我们写一个.java文件
        Class<?> clazz = groovyClassLoader.parseClass("package mg.demo;\n" +
                "\n" +
                "public class MgSample {\n" +
                "\n" +
                "    public int age = 22;\n" +
                "    \n" +
                "    public void sayHello() {\n" +
                "        System.out.println(\"年龄是:\" + age);\n" +
                "    }\n" +
                "}\n");

        System.out.println(clazz.getName());
        Object obj = clazz.newInstance();
        Method method = clazz.getDeclaredMethod("sayHello");
        method.invoke(obj);
//        Class cl = Class.forName("mg.demo.MgSample");

//        Thread.currentThread().getContextClassLoader().loadClass("mg.demo.MgSample");

        URL url = groovyClassLoader.getResource("/");

//        System.out.println(cl.getName());
        System.out.println(url);

        Object val = method.getDefaultValue();
        System.out.println(val);
    }
}
