package com.mg.knowledge.design.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DynamicProxy<T> {

    public static <T> T newProxyInstance(ClassLoader classLoader, Class<?>[] interfaces, InvocationHandler h)
    {
        if(true)
        {
            System.out.println("begin");
        }

        return (T) Proxy.newProxyInstance(classLoader,interfaces,h);
    }
}
