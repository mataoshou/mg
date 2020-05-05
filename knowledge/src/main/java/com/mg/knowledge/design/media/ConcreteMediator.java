package com.mg.knowledge.design.media;

public class ConcreteMediator extends Mediator {
    @Override
    public void doSomething1() {
//        super.c1.selfMethod1();
        super.c2.selfMethod1();
    }

    @Override
    public void doSomething2() {
        super.c1.selfMethod2();
//        super.c2.selfMethod2();
    }
}
