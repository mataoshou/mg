package com.mg.knowledge.design.media;

public class ConcreteColleague1 extends Colleague {
    public ConcreteColleague1(Mediator _mediator) {
        super(_mediator);
    }


    public void selfMethod1()
    {
        System.out.println("i am  ConcreteColleague1 selfMethod1");
    }

    public void selfMethod2()
    {
        System.out.println("i am  ConcreteColleague1 selfMethod2");
    }

    public void depMethod1()
    {
        selfMethod1();
        mediator.doSomething1();
    }

}
