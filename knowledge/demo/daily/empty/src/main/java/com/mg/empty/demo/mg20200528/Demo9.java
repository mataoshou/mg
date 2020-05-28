package com.mg.empty.demo.mg20200528;

import java.util.ArrayList;
import java.util.List;

public class Demo9{

    public void setList(List<? super Father> list){
    }

    public static void main(String[]args){
        Demo9 demo9 = new Demo9();
        demo9.setList(new ArrayList<Grandpa>());
//        demo9.setList(new ArrayList<Son>());
    }
}
