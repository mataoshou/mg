package com.mg.empty.demo.alt.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Lock;

@Slf4j
public class Mg2020092504 {
    public int maxArea(int[] height) {
        int max = 0;
        int left =0;
        int right = height.length-1;

        while (left<right)
        {
            int index = Integer.min(height[left],height[right]);
            int tmp = index*(right-left);
            if(max<tmp)max=tmp;

            Lock
            if(height[left]<height[right]){left++;}
            else {right--;}
        }

        return max;
    }

    public static void main(String[] args) {
        Mg2020092504 mg2020092504 = new Mg2020092504();
        int[] ints = new int[]{1,8,6,2,5,4,8,3,7};
        log.info("{}",mg2020092504.maxArea(ints));
    }
}
