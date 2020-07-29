package com.mg.empty.demo.jvm.createCl;

import org.springframework.cglib.core.ClassGenerator;
import org.springframework.cglib.core.DefaultGeneratorStrategy;
import org.springframework.cglib.proxy.Enhancer;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class MgDemo2020070803 {
    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, MalformedURLException {
        int no =12;
        System.out.println(no);
        demo1();
        URL url = new URL("file:/d:/cltmp/");
        URLClassLoader classLoader = new URLClassLoader(new URL[]{url});
        Class cl = classLoader.loadClass("MgDemoSample");
        Class cl2 = classLoader.loadClass("MgDemoSample");
        System.out.println(cl.equals(cl2));

        URLClassLoader classLoader2 = new URLClassLoader(new URL[]{url});
        Class cl3 = classLoader2.loadClass("MgDemoSample");
        System.out.println(cl.hashCode());
        System.out.println(cl2.hashCode());
        System.out.println(cl3.hashCode());
        System.out.println(cl.equals(cl3));
    }

    public static void demo1() throws FileNotFoundException {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
//        FileInputStream inputStream = new FileInputStream("E:\\core\\mg\\knowledge\\demo\\boot\\empty\\src\\main\\java\\com\\mg\\empty\\demo\\jvm\\createCl\\MgDemo2020070803.java");
//
//        FileOutputStream outputStream = new FileOutputStream("E:\\mg.shineon\\MgDemo2020070803.class");

        int compilationResult = compiler.run(null, null, null,
                "-d","d:\\cltmp"
                ,"d:\\core\\mg\\knowledge\\demo\\boot\\empty\\src\\main\\java\\com\\mg\\empty\\demo\\jvm\\createCl\\MgDemoSample.java");

        System.out.println(compilationResult);
    }
}
