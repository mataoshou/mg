package com.mg.empty.demo.jvm.classload;

import sun.misc.Launcher;
import sun.misc.URLClassPath;

import java.net.URL;
import java.net.URLClassLoader;

public class BootstrapDemo {

    public static void main(String[] args) {
        URLClassPath path = Launcher.getBootstrapClassPath();
        for(URL url : path.getURLs()){
            System.out.println(url.getPath());
        }
        System.out.println("----------------------------");
        //取得扩展类加载器
        URLClassLoader extClassLoader = (URLClassLoader)ClassLoader.getSystemClassLoader().getParent();
        for(URL url : extClassLoader.getURLs())
            System.out.println(url);

        System.out.println("----------------------------");


        //取得应用(系统)类加载器
        URLClassLoader appClassLoader = (URLClassLoader)ClassLoader.getSystemClassLoader();
        for(URL url : appClassLoader.getURLs())
            System.out.println(url);

        System.out.println("----------------------------");
    }
}
