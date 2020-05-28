package com.mg.empty.demo.mg20200528;

public class Demo6 {
    public <T> T getT(T t)
    {
        return t;
    }
    public <M> void show(M m)
    {
        System.out.println(m);
    }
    public static void main(String[] args) {
        Demo6 demo6 = new Demo6();
        Integer no = demo6.getT(1);
        String str = demo6.getT("mg");
        demo6.<String>show("mg");
    }
}
