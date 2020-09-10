package com.mg.empty.demo.alt.sort;

public class BubbleSort {
    public void bubbleSort(int[] count)
    {
        for(int i=0;i<count.length;i++)
        {
            for(int j=0;i<count.length-1;j++)
            {
                if(count[j]>count[j+1])
                {
                    int tmp = count[j];
                    count[j] = count[j+1];
                    count[j+1] = tmp;
                }
            }
        }
    }
}
