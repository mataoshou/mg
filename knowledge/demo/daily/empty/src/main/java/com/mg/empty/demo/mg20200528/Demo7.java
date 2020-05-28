package com.mg.empty.demo.mg20200528;

import java.util.ArrayList;

public class Demo7 {
    public static <T> void getT(T t){
        if(t instanceof String)
        {

        }
        System.out.println(t);
    }

    public <T> void setT(T t,Class<T> cl)
    {

    }
    public static void main(String[] args) {

        Demo7.getT("1");

        ArrayList<String> list = new ArrayList<>();
    }
}
