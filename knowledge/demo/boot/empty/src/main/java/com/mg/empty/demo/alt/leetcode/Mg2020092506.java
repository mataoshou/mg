package com.mg.empty.demo.alt.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Mg2020092506 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result= new ArrayList<>();

        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>0)break;
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int right =nums.length-1;
            int left =i+1;
            while(left<right)
            {
                int tmp = nums[i]+nums[left]+nums[right];
                if(tmp==0)
                {
                    List list = new ArrayList();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    if(!result.contains(list))
                        result.add(list);
                    while(left < right && nums[left+1] == nums[left]) ++left;
                    while (left < right && nums[right-1] == nums[right]) --right;
                    ++right;
                    --left;
                }
                else if(tmp<0)left++;
                else right--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Mg2020092506 mg2020092506 =new Mg2020092506();
        mg2020092506.threeSum(new int[]
                {

                -1,0,1,2,-1,-4
                });
    }
}
