package com.mg.empty.demo.alt.sort;

import com.mg.empty.demo.alt.util.ShowUtill;

public class QuickSort {

    public void sort(int[] array,int left,int right)
    {
        int index =left;
        int tmp = array[left];
        int leftIndex = left;
        int rightIndex = right;
        if(left>=right) return;

        while(leftIndex<rightIndex)
        {
            while(leftIndex<rightIndex)
            {
                if(array[rightIndex]<tmp)
                {
                    array[index] = array[rightIndex];
                    index = rightIndex;
                    break;
                }
                rightIndex--;
            }

            while(leftIndex<rightIndex)
            {
                if(array[leftIndex]>tmp)
                {
                    array[index] = array[leftIndex];
                    index = leftIndex;
                    break;
                }
                leftIndex++;
            }
        }

        array[index] = tmp;

        sort(array,left,index-1);
        sort(array,index+1,right);
    }

    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
        int[] array = new int[]{10,5,20,30,8,45,15,9} ;
        sort.sort(array,0,7);
        ShowUtill.showArray(array);
    }
}
