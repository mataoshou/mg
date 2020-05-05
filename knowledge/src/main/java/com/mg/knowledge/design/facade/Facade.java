package com.mg.knowledge.design.facade;

public class Facade {

    private ClassA classA = new ClassA();
    private ClassB classB = new ClassB();
    private ClassC classC = new ClassC();

    public void methodA()
    {
        this.classA.doSomethingA();
    }

    public void methodB()
    {
        this.classB.doSomething();
    }

    public void methodC()
    {
        this.classC.doSomething();
    }
}
