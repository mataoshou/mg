package com.mg.empty.demo.mg20200528;

public class Demo2<T,M> {

    private  T t;
    private M m;

    public void setValue(T t,M m)
    {
        this.t= t;
        this.m = m;
    }

    public T getT()
    {
        return t;
    }

    public static void main(String[] args) {
        Demo2<Integer,String> demo2 = new Demo2<Integer,String>();
        demo2.setValue(1,"1");
        Integer no =demo2.getT();
        System.out.println(no);
    }
}
