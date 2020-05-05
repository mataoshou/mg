package com.mg.knowledge.design.proxy.dynamic;

public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("....run realSubject");
    }
}
