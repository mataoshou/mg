package com.mg.knowledge.design.command;

public class Client {

    public static void main(String[] args) {
        Invoker invoker = new Invoker();

        Receiver receiver = new ConcreteReceiver1();

        Command command = new ConcreteCommand1(receiver);

        invoker.setCommand(command);
        invoker.action();
    }
}
