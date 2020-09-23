package com.mg.empty.demo.alt.leetcode;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

import java.util.HashMap;

public class Mg20200921 {

    public int[] twoSum(int[] nums, int target) {
        int result[] = new int[2];
        HashMap<Integer,Integer> map = new HashMap();
        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i],i);
        }

        for(int i=0;i<nums.length;i++)
        {
            int tmp = target -nums[i];
            if(map.get(tmp)!=null&&map.get(tmp)!=i)
            {
                result[0] = i;
                result[1]= map.get(tmp);
                return result;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Mg20200921 mg20200921= new Mg20200921();
        mg20200921.twoSum(new int[]{3,2,4},6);
    }
}
