package com.mg.knowledge.design.single;

public class UnsafeSinglePattern {

    public static UnsafeSinglePattern single ;

    private UnsafeSinglePattern(){}

    public static UnsafeSinglePattern getSingle()
    {
        if(single==null)
        {
            single = new UnsafeSinglePattern();
        }
        return single;
    }

    public void doSomething()
    {
        System.out.println("i am unsafe single pattern");
    }

    public static void main(String[] args) {
        UnsafeSinglePattern.getSingle().doSomething();
    }
}
