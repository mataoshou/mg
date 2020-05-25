package com.mg.knowledge.design.observer;

import java.util.Vector;

public abstract class Subject {

    private Vector<Observer> obsVector = new Vector<Observer>();


    public void addObserver(Observer o)
    {
        this.obsVector.add(o);
    }


    public void deleteObserver(Observer o)
    {
        this.obsVector.remove(o);
    }


    public void norifyObserver()
    {
        for(Observer o : this.obsVector)
        {
            o.update();
        }
    }

}
