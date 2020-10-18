package com.mg.empty.demo.alt.leetcode;

public class Mg2020100901 {

    int count =0;
    public int reversePairs(int[] nums) {
        divide(nums,0,nums.length-1);
        return count;
    }

    public void divide(int[] nums,int left,int right)
    {
        if(left>=right)return;

        int middle = (left+right)/2;

        divide(nums,left,middle);
        divide(nums,middle+1,right);
        int l = left;
        int r=middle+1;

        while (l<=middle&&r<=right)
        {
            if(nums[l]>right)
            {
                count+=right-l+1;
                l++;
            }
        }

    }

}
