package com.mg.empty.demo.mg20200605;

import java.util.ArrayList;
import java.util.List;

public class HeapSpace {

    public static void main(String[] args) {
        for(int i=0;i<100;i++)
        {
            new Thread(()->{
                List<String> list = new ArrayList();
               while(true)
               {
                   list.add(System.currentTimeMillis() +"mg" + System.currentTimeMillis());
               }
            }).start();
        }
    }
}
