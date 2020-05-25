package com.mg.knowledge.design.builder;

public class ConcreteBuilder extends Builder {
    @Override
    public void setPart() {

    }

    @Override
    public Product buildProdect() {
        return new Product();
    }
}
