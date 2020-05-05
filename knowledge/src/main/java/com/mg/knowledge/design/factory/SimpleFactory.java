package com.mg.knowledge.design.factory;

public class SimpleFactory  {
    public Product createProduce(Class<? extends Product> cl) {
        try {
            return cl.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        SimpleFactory factory = new SimpleFactory();

        factory.createProduce(ConcreteProduct1.class).doSomeThing();

        factory.createProduce(ConcreteProduct2.class).doSomeThing();
    }
}