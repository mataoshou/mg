package com.mg.empty.demo.refence.weak;

import java.lang.ref.WeakReference;

public class MgDemo2020062716 {
    public static void main(String[] args) throws InterruptedException {
        WeakReference<MgDemo2020062716> reference = new WeakReference(new MgDemo2020062716());
        System.out.println(reference.get());
        System.gc();
        System.out.println(reference.get());
    }
}
