package com.mg.empty.demo.refence.strong;

import java.util.ArrayList;

public class MgDemo2020062714 {
    public static void main(String[] args) {
        ArrayList list= new ArrayList();
        while(true) {
            String obj = System.currentTimeMillis() +"";
            list.add(obj);
            System.out.println(list.get(0));
        }
    }

}
