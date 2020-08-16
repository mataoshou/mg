package com.mg.empty.demo.jvm.classload;

import lombok.extern.slf4j.Slf4j;
import sun.misc.Launcher;
import sun.misc.URLClassPath;

import java.net.URL;
import java.net.URLClassLoader;

@Slf4j
public class BootstrapDemo {

    public static void main(String[] args) {
        URLClassPath path = Launcher.getBootstrapClassPath();
        for(URL url : path.getURLs()){
            System.out.println(url.getPath());
        }
        System.out.println("----------------------------");
//        //取得扩展类加载器
//        URLClassLoader extClassLoader1 = (URLClassLoader)ClassLoader.getSystemClassLoader().getParent().getParent();
//        for(URL url : extClassLoader1.getURLs()){
//            System.out.println(url.getPath());
//        }
        System.out.println("----------------------------");
        //取得扩展类加载器
        URLClassLoader extClassLoader = (URLClassLoader)ClassLoader.getSystemClassLoader().getParent();

        System.out.println(extClassLoader);
        for(URL url : extClassLoader.getURLs()) {
            System.out.println(url.getPath());
        }

        System.out.println("----------------------------");


        //取得应用(系统)类加载器
        URLClassLoader appClassLoader = (URLClassLoader)ClassLoader.getSystemClassLoader();
        System.out.println(appClassLoader);
        for(URL url : appClassLoader.getURLs()) {
            log.info(url.getPath());
        }
        System.out.println("----------------------------");

//
//        System.gc();

    }
}
