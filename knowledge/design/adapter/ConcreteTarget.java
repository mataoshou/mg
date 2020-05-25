package com.mg.knowledge.design.adapter;

public class ConcreteTarget implements Target {
    @Override
    public void request() {
        System.out.println("pls call me!");
    }
}
