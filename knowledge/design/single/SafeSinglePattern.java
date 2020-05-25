package com.mg.knowledge.design.single;

public class SafeSinglePattern {
    public static SafeSinglePattern single ;

    private SafeSinglePattern(){}

    public static SafeSinglePattern getSingle()
    {
        if(single==null)
        {
            synchronized(SafeSinglePattern.class)
            {
                if(single ==null)
                {
                    single = new SafeSinglePattern();
                }
            }

        }
        return single;
    }

    public void doSomething()
    {
        System.out.println("i am safe single pattern");
    }

    public static void main(String[] args) {
        SafeSinglePattern.getSingle().doSomething();
    }
}
