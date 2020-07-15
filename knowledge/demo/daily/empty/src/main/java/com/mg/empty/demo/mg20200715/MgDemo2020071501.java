package com.mg.empty.demo.mg20200715;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

@Slf4j
public class MgDemo2020071501 {

    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        URL url = new URL("file:/E:/cltmp/");
        URLClassLoader loader = new URLClassLoader(new URL[]{url});

        Class cl = loader.loadClass("MgDemoSample");
        Class cl2 = loader.loadClass("MgDemoSample");
        log.info("....{}",cl.getName());
        Object instance = cl.newInstance();
        Method mainMethod = cl.getMethod("startSample");
        mainMethod.invoke(instance);
        URLClassLoader loader2 = new URLClassLoader(new URL[]{url});
        Class cl3 = loader2.loadClass("MgDemoSample");

        log.info("{}",cl.equals(cl2));
        log.info("{}",cl.equals(cl3));
    }
}
