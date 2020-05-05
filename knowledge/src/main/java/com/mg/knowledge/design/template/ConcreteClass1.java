package com.mg.knowledge.design.template;

public class ConcreteClass1 extends AbstractClass {
    @Override
    protected void doSomething() {
        System.out.println("class ConcreteClass1 method doSomething");
    }

    @Override
    protected void doAnything() {
        System.out.println("class ConcreteClass1 method doAnything");
    }
}
