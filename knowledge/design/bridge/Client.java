package com.mg.knowledge.design.bridge;

public class Client {

    public static void main(String[] args) {
        Implementor implementor = new ConcreteImplementor1();
        Abstraction abs = new RefinedAbstraction(implementor);

        abs.request();
    }
}
