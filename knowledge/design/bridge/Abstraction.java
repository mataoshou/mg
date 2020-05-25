package com.mg.knowledge.design.bridge;

public class Abstraction {

    private Implementor imp;

    public Abstraction(Implementor _imp)
    {
        this.imp = _imp;
    }

    public void request()
    {
        this.imp.doAnything();
    }

    public Implementor getImp()
    {
        return imp;
    }

}
