package com.mg.knowledge.design.proxy.force;

public class ProxySubject implements ISubject{

    @Override
    public void doSomething() {
        System.out.println("in proxy");
        subject.doSomething();
    }

    public ProxySubject(ISubject subject)
    {
        this.subject =subject;
    }

    private ISubject subject = null;

    @Override
    public ISubject getProxy() {
        return this;
    }
}
