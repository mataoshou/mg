package com.mg.knowledge.design.proxy.dynamic;

import java.lang.reflect.InvocationHandler;

public class Client {

    public static void main(String[] args) {
        Subject subject = new RealSubject();

        InvocationHandler handler = new SubjectHandler(subject);


        Subject proxy = DynamicProxy.newProxyInstance(subject.getClass().getClassLoader(),new Class[]{Subject.class},handler);

        proxy.request();
//        proxy.request();
    }
}
