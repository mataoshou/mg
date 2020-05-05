package com.mg.knowledge.design.state;

public class ConcreteState2 extends State {
    @Override
    public void handle1() {
        super.context.setCurrentState(context.STATE1);
        super.context.handle1();

    }

    @Override
    public void handle2() {
        System.out.println("2.2");
    }
}
