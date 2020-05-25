package com.mg.knowledge.design.single;

public class SinglePattern {

    public static final SinglePattern single = new SinglePattern();

    private SinglePattern(){}

    public static SinglePattern getSingle()
    {
        return single;
    }

    public void doSomething()
    {
        System.out.println("i am single pattern");
    }

    public static void main(String[] args) {
        SinglePattern.getSingle().doSomething();
    }
}
