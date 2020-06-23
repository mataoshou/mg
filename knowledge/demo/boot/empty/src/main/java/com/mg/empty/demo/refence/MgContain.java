package com.mg.empty.demo.refence;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class MgContain  extends WeakReference<MgItem> {
    public MgContain(MgItem referent) {
        super(referent);
        referent.setId(10);
    }

    public MgContain(MgItem referent, ReferenceQueue<? super MgItem> q) {
        super(referent, q);
    }

    public static void main(String[] args) throws InterruptedException {
        MgItem item = new MgItem();
        MgContain contain = new MgContain(new MgItem());
//        MgContain contain = new MgContain(item);

        System.out.println(contain.get().getId());

        System.gc();
        Thread.sleep(1000*5);

        System.out.println(contain.get());
    }
}
