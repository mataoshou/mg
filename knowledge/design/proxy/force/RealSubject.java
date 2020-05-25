package com.mg.knowledge.design.proxy.force;

public class RealSubject implements ISubject {
    @Override
    public void doSomething() {
        System.out.println("in real obejct");
    }

    ISubject proxy = null;

    @Override
    public ISubject getProxy() {
        this.proxy = new ProxySubject(this);
        return proxy;
    }
}
