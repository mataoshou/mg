package com.mg.knowledge.design.factory.MethodFactory;

import com.mg.knowledge.design.factory.ConcreteProduct2;
import com.mg.knowledge.design.factory.Product;

public class ConcreteFactory2 extends  Factory {
    @Override
    public Product create() {
        return new ConcreteProduct2();
    }
}
