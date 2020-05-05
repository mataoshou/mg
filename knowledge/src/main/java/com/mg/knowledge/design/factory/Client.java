package com.mg.knowledge.design.factory;

public class Client {
    public static void main(String[] args) {
        Creator creator = new ConcreteCreator();

        Product product=creator.createProduce(ConcreteProduct1.class);
        product.doSomeThing();

        Product product1 = creator.createProduce(ConcreteProduct2.class);
        product1.doSomeThing();
    }
}
