package com.mg.knowledge.design.command;

public class ConcreteCommand2  extends Command  {


    private Receiver receiver;

    public ConcreteCommand2(Receiver receiver)
    {
        this.receiver.doSomething();
    }



    @Override
    public void execute() {

    }
}
