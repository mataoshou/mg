package com.mg.knowledge.design.visitor;

public class ConcreteElement2 extends Element {
    @Override
    public void doSomething() {
        System.out.println("i am element2");
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
