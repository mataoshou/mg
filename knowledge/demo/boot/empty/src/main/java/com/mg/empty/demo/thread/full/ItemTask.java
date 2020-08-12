package com.mg.empty.demo.thread.full;

import java.util.ArrayList;
import java.util.List;

public class ItemTask implements Runnable{

    List<String> list = new ArrayList<>();
    @Override
    public void run() {
        while(true) {
            try {
                String str = Thread.currentThread().getName()+ "[MG]" + System.currentTimeMillis() + "" + System.currentTimeMillis()
                        + "" + System.currentTimeMillis()
                        + "" + System.currentTimeMillis();

                list.add(str);
                System.out.println(str);
                Thread.sleep(10);
            }
            catch (Exception e)
            {

            }
        }
    }

    public static void main(String[] args) {
        for(int i=0;i<1000;i++) {
            Thread task = new Thread(new ItemTask());
            task.start();
        }
    }
}
