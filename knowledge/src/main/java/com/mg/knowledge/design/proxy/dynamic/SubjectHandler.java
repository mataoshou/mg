package com.mg.knowledge.design.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SubjectHandler implements InvocationHandler {

    Object obj;

    public SubjectHandler(Object obj)
    {
        this.obj=obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(this.obj,args);
        System.out.println("i am in proxy");
        return result;
    }
}
