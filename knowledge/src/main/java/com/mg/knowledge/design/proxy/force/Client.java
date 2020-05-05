package com.mg.knowledge.design.proxy.force;

public class Client {

    public static void main(String[] args) {
        ISubject subject = new RealSubject().getProxy();
        subject.doSomething();
    }
}
