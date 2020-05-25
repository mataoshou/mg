package com.mg.knowledge.design.decorator;

public class ConcreteDecorator2 extends Decorator {
    public ConcreteDecorator2(Component _component) {
        super(_component);
    }


    public void method2()
    {
        System.out.println("decorator1 method2");
    }


    @Override
    public void operate() {
        super.operate();
        this.method2();
    }
}
