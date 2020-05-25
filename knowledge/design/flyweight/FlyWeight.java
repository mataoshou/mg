package com.mg.knowledge.design.flyweight;

public abstract class FlyWeight {

    private String intrinsic;

    protected final String extrinsic;


    public FlyWeight(String  _extrinsic)
    {
        this.extrinsic = _extrinsic;
    }


    public abstract void operte();

    public String getIntrinsic()
    {
        return intrinsic;
    }

    public void setIntrinsic(String intrinsic)
    {
        this.intrinsic = intrinsic;
    }



}
