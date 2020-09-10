package com.mg.empty.demo.alt.sort;

import com.mg.empty.demo.alt.util.ShowUtill;

/**
 * 算法思路，将最小的放在第一个
 * 然后 获取出剩余的最小值 放在第二个位置
 * 依次排序成功
 */
public class SelectSort {

    public void selectSort(int[] array)
    {
        for(int i=0;i<array.length-1;i++)
        {
            int index =i;
            for(int j=i+1;j<array.length;j++)
            {
                if(array[j]<array[index])
                {
                    index = j;
                }
            }
            int tmp = array[i];
            array[i] = array[index];
            array[index] = tmp;
        }
        ShowUtill.showArray(array);
    }

    public static void main(String[] args) {
        SelectSort selectSort = new SelectSort();
        selectSort.selectSort(new int[]{100,9,3,2,7,15,300,12});
    }
}
