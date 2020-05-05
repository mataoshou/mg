package com.mg.knowledge.design.abstractfactory;

public class Create1 extends  AbstractCreator {
    @Override
    public AbstractProductA productA() {
        return new ProductA1();
    }

    @Override
    public AbstractProductB productB() {
        return new ProductB1();
    }
}
