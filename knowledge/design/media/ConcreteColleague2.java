package com.mg.knowledge.design.media;

public class ConcreteColleague2 extends  Colleague {
    public ConcreteColleague2(Mediator _mediator) {
        super(_mediator);
    }

    public void selfMethod1()
    {
        System.out.println("i am  ConcreteColleague2 selfMethod1");
    }

    public void selfMethod2()
    {
        System.out.println("i am  ConcreteColleague2 selfMethod2");
    }

    public void depMethod2()
    {
        mediator.doSomething2();
    }
}
