package com.mg.knowledge.design.memento;

public class Clent {

    public static void main(String[] args) {
        Originator originator = new Originator();

        Caretaker caretaker = new Caretaker();

        caretaker.setMemento(originator.createMemento());

        originator.restoreMemento(caretaker.getMemento());
    }
}
