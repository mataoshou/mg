package com.mg.knowledge.design.composite;

public class Leaf extends  Component {

    @Override
    public void doSomething() {
        super.doSomething();
        System.out.println("in leaf");
    }
}
