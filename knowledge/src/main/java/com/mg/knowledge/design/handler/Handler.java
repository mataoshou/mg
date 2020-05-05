package com.mg.knowledge.design.handler;

public abstract class Handler {

    private Handler nextHandler;

    public final Response HandleMessage(Request request)
    {
        Response response = null;

        if(this.getHandlerLevel().equals(request.getRequestLevel()))
        {
            response = this.echo(request);
        }
        else{
            if(this.nextHandler!=null)
            {
                response = this.nextHandler.HandleMessage(request);
            }
            else{

            }
        }

        return  response;

    }

    public void setNext(Handler _handler)
    {
        this.nextHandler = _handler;
    }

    protected abstract Level getHandlerLevel();

    protected abstract Response echo(Request request);
}
