package com.mg.knowledge.design.template;

public abstract class AbstractClass {

    protected abstract void doSomething();

    protected abstract void doAnything();

    public void templateMethod(){
        this.doAnything();
        this.doSomething();
    }
}
