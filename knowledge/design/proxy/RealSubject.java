package com.mg.knowledge.design.proxy;

public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("....run realSubject");
    }
}
