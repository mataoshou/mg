package com.mg.knowledge.design.decorator;

public class ConcreteDecorator1 extends Decorator {
    public ConcreteDecorator1(Component _component) {
        super(_component);
    }

    public void method1()
    {
        System.out.println("decorator1 method1");
    }

    @Override
    public void operate() {
        this.method1();
        super.operate();
    }
}
