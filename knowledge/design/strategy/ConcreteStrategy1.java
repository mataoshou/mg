package com.mg.knowledge.design.strategy;

public class ConcreteStrategy1 implements Strategy {
    @Override
    public void doSomething() {
        System.out.println("策略1");
    }
}
