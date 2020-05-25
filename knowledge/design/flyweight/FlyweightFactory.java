package com.mg.knowledge.design.flyweight;

import java.util.HashMap;

public class FlyweightFactory {

    private static HashMap<String,FlyWeight> pool = new HashMap();


    public static FlyWeight getFlyWeight(String extrinsic)
    {

        FlyWeight flyWeight = null;

        if(pool.containsKey(extrinsic))
        {
            flyWeight = pool.get(extrinsic);
        }

        else{
            flyWeight = new ConcreteFlyWeight(extrinsic);
            pool.put(extrinsic,flyWeight);

        }
        return flyWeight;
    }


}
