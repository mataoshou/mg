package com.mg.knowledge.design.factory;

public class ConcreteCreator extends Creator {
    @Override
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
}
