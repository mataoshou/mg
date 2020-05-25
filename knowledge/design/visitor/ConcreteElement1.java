package com.mg.knowledge.design.visitor;

public class ConcreteElement1 extends Element {
    @Override
    public void doSomething() {
        System.out.println("i am element1");
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
