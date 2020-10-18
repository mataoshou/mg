package com.mg.empty.demo.alt.leetcode;

public class Mg2020100802 {

    public int search(int[] nums, int target) {
        return search(nums,target,0,nums.length-1);
    }

    public int search(int[] nums,int target,int left,int right)
    {
        if(left>right)return 0;
        if(left==right) {
            if (nums[left] == target) return 1;
            else return 0;
        }
        int index=0;
        int middle = (left+right)/2;
        if(nums[middle]==target)
        {
            index++;
            int tmp = middle-1;
            while(tmp>=left)
            {
                if(nums[tmp]==target)
                {index++;tmp--;}
                else break;
            }
            tmp=middle+1;
            while(tmp<=right)
            {
                if(nums[tmp]==target){
                    index++;tmp++;
                }
                else break;
            }
            return index;
        }
        else if(nums[middle]>target)
        {
            return search(nums,target,left,--middle);
        }else {
            return search(nums,target,++middle,right);
        }


    }

    public static void main(String[] args) {
        Mg2020100802 mg2020100802 = new Mg2020100802();
        System.out.println(mg2020100802.search(new int[]{2,2}, 2));
    }

}
