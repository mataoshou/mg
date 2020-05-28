package com.mg.empty.demo.mg20200528;

import java.util.ArrayList;
import java.util.List;

public class Demo1 {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new Object());
        list.add(new Object());
        String str = (String) list.get(0);
    }
}
