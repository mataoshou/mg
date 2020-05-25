package com.mg.knowledge.design.decorator;

public class ConcreteComponent extends  Component {
    @Override
    public void operate() {
        System.out.println("do someThing");
    }
}
