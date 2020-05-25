package com.mg.knowledge.design.media;

public abstract class Colleague {
    protected Mediator mediator;

    public Colleague(Mediator _mediator)
    {
        this.mediator = _mediator;
    }
}
