package com.mg.knowledge.design.factory;

public abstract class Creator {


    public abstract Product createProduce(Class<? extends Product> cl);

}
