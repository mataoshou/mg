package com.mg.knowledge.design.factory.MethodFactory;

import com.mg.knowledge.design.factory.ConcreteProduct1;
import com.mg.knowledge.design.factory.Product;

public class ConcreteFactory1 extends Factory {
    @Override
    public Product create() {
        return new ConcreteProduct1();
    }
}
