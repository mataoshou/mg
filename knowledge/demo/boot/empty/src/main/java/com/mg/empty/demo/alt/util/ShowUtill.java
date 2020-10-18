package com.mg.empty.demo.alt.util;

import com.mg.empty.demo.alt.data.ListNode;

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

    public static void showList(ListNode node)
    {
        System.out.println("....................begin...................");
        while(node!=null)
        {
            System.out.print(node.val +"  ");
            node = node.next;
        }
        System.out.println();
        System.out.println("....................end.....................");
    }

}
