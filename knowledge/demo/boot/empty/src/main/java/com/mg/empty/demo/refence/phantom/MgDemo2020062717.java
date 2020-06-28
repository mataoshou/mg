package com.mg.empty.demo.refence.phantom;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class MgDemo2020062717 {
    public static void main(String[] args) {
        ReferenceQueue<MgDemo2020062717> referenceQueue = new ReferenceQueue<>();
        PhantomReference<MgDemo2020062717> reference = new PhantomReference(new MgDemo2020062717(),referenceQueue);
        System.out.println(reference.get());

    }

}
