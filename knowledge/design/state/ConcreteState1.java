package com.mg.knowledge.design.state;

public class ConcreteState1 extends State {
    @Override
    public void handle1() {
        System.out.println("1.1");
    }

    @Override
    public void handle2() {
        super.context.setCurrentState(context.STATE2);
        super.context.handle2();

    }
}
