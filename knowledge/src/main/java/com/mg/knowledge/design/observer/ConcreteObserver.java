package com.mg.knowledge.design.observer;

public class ConcreteObserver implements Observer {
    @Override
    public void update() {
        System.out.println("接收到消息,请处理！");
    }
}
