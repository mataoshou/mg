package com.mg.knowledge.design.handler;

public class Client {

    public static void main(String[] args) {
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();
        Handler handler3 = new ConcreteHandler3();

        handler1.setNext(handler2);
        handler1.setNext(handler3);

        Response response = handler1.HandleMessage(new Request());

    }
}
