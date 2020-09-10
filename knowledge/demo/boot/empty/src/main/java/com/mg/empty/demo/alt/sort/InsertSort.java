package com.mg.empty.demo.alt.sort;

import com.mg.empty.demo.alt.util.ShowUtill;
import org.apache.tomcat.util.security.Escape;

public class InsertSort {

    public void insertionSort(int[] array)
    {
        for(int i=1;i<array.length;i++)
        {
            int tmp = array[i];
            int index =i;
            for(int j =i-1;j>=0;j--)
            {
                if(array[j]>tmp)
                {
                    array[index]=array[j];
                    index=j;
                    array[index] = tmp;


                }
                else {
                    array[index]=tmp;
                    continue;
                }
            }
        }

        ShowUtill.showArray(array);
    }

    public static void main(String[] args) {
        InsertSort sort = new InsertSort();
        sort.insertionSort(new int[]{100,9,3,2,7,15,300,12});
    }
}
