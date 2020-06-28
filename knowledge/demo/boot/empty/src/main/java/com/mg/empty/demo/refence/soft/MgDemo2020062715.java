package com.mg.empty.demo.refence.soft;

import java.lang.ref.SoftReference;
import java.util.ArrayList;

public class MgDemo2020062715 {
    public static void main(String[] args) {
        SoftReference<MgDemo2020062715> reference = new SoftReference(new MgDemo2020062715());
//        System.gc();
//        System.out.println(reference.get());

        ArrayList list = new ArrayList();
        while(true)
        {
            String obj = System.currentTimeMillis() +"";
            list.add(obj);
            System.out.println(reference.get());
        }

    }
}
