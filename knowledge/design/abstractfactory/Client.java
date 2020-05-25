package com.mg.knowledge.design.abstractfactory;

public class Client {

    public static void main(String[] args) {
        AbstractCreator creator1 = new Create1();

        creator1.productA().doSomething();;
        creator1.productB().doSomething();


        AbstractCreator creator2 = new Create2();


        creator2.productA().doSomething();
        creator2.productB().doSomething();
    }
}
