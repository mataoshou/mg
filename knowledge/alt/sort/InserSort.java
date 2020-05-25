package com.mg.knowledge.alt.sort;

import com.mg.knowledge.alt.util.ShowArr;

/**
 * 插入排序
 */
public class InserSort {

    public static void sort(int[] arr)
    {
        int length = arr.length;
        for(int i=1;i<length;i++)
        {
            for(int j=i;j>0;j--)
            {
                if(arr[j]<arr[j-1])
                {
                    int tmp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] =tmp;
                }
            }
        }

        ShowArr.show(arr);

    }

    public static void main(String[] args)
    {
        int[] arr = new int[]{2,5,7,1,78,23};
        sort(arr);

    }
}
