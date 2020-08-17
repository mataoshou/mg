package com.mg.empty.demo.jvm.classload;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.util.Assert;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class MgDemo {
    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        URL url = new URL("file:/E:/cltmp/");
        URLClassLoader classLoader1 = new URLClassLoader(new URL[]{url});
        Class cl1 = classLoader1.loadClass("MgDemoSample");
        URLClassLoader classLoader2 = new URLClassLoader(new URL[]{url});
        Class cl2 = classLoader2.loadClass("MgDemoSample");


//        XmlBeanFactory
        System.out.println(cl1);
        System.out.println(cl2);
        System.out.println(cl1.equals(cl2));
        Assert.isTrue(cl1.equals(cl2),"not one class");
    }


}
