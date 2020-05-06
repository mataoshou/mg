package com.mg.knowledge.design.factory.MethodFactory;

public class Main {

    public static void main(String[] args) {
        Factory factory = new ConcreteFactory1();
        factory.create().doSomeThing();

        factory = new ConcreteFactory2();
        factory.create().doSomeThing();
    }
}
