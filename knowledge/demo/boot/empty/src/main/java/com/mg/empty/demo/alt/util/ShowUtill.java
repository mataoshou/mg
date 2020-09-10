package com.mg.empty.demo.alt.util;

public class ShowUtill {

    public static void showArray(int[] array)
    {
        System.out.println("....................begin...................");
        for(int i=0;i<array.length;i++)
        {
            System.out.print(array[i] +"  ");
        }
        System.out.println();
        System.out.println("....................end.....................");
    }

}
