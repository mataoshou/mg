package com.mg.knowledge.design.command;

public class ConcreteCommand1 extends Command {

    private Receiver receiver;

    public ConcreteCommand1(Receiver receiver)
    {
        this.receiver.doSomething();
    }


    @Override
    public void execute() {

    }
}
