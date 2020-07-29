package com.mg.empty.demo.jvm.classload;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class MgDemo {
    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        URL url = new URL("file:/D:/cltmp/");
        URLClassLoader classLoader1 = new URLClassLoader(new URL[]{url});
        Class cl1 = classLoader1.loadClass("MgDemoSample");
        Class cl2 = classLoader1.loadClass("MgDemoSample");
        URLClassLoader classLoader2 = new URLClassLoader(new URL[]{url});
        Class cl3 = classLoader2.loadClass("MgDemoSample");


        System.out.println(cl1);
        System.out.println(cl2);
        System.out.println(cl3);
        System.out.println(cl1.equals(cl2));
        System.out.println(cl1.equals(cl3));


    }
}
