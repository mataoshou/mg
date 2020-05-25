package com.mg.knowledge.design.abstractfactory;

public class Create2 extends AbstractCreator {
    @Override
    public AbstractProductA productA() {
        return new ProductA2();
    }

    @Override
    public AbstractProductB productB() {
        return new ProductB2();
    }
}
