package com.mg.knowledge.design.template;

public class ConcreteClass2 extends  AbstractClass {
    @Override
    protected void doSomething() {
        System.out.println("class ConcreteClass2 method doSomething");
    }

    @Override
    protected void doAnything() {
        System.out.println("class ConcreteClass2 method doAnything");
    }
}
