package com.mg.empty.demo.mg20200528;

public class Demo8<T extends Father> {
    public static void main(String[] args) {
        Demo8<Son> demo8 = new Demo8<>();
        Demo8<Father> demo81 = new Demo8<>();
//        Demo8<Grandpa> demo82 = new Demo8();
    }
}
