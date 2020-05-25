package com.mg.knowledge.design.proxy;

public class Proxy implements Subject {

    private Subject subject =null;

    public Proxy()
    {
        this.subject = new RealSubject();
    }

    public void before()
    {
        System.out.println("run before");
    }

    public void after(){
        System.out.println("run after");
    }

    @Override
    public void request() {
        this.before();

        this.subject.request();

        this.after();
    }

    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        proxy.request();
    }
}
