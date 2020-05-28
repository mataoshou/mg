package com.mg.empty.demo.mg20200528;

public class Demo5<T> implements Demo3<T> {
    @Override
    public T getT() {
        return null;
    }

    public static void main(String[] args) {
        Demo5<String> demo5 = new Demo5<>();
    }
}
