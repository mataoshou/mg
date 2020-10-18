package com.mg.empty.demo.alt.leetcode;

public class Mg2020100806 {

    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];

        for(int i=0;i<nums.length;i++)
        {
            strs[i]= String.valueOf(nums[i]);
        }

        fastSort(strs,0,strs.length-1);

        String result = "";
        for(String s : strs)
        {
            result+=s;
        }
        return result;
    }

    public void fastSort(String[] str,int left,int right)
    {
        if(left>=right)return;

        String index = str[left];

        int tmpl =left;
        int tmpr = right;
        while(tmpl<tmpr){
            while(tmpl<tmpr)
            {
                if((index+str[tmpr]).compareTo(str[tmpr]+index)>0)
                {
                    str[tmpl] = str[tmpr];
                    break;
                }
                tmpr--;
            }

            while(tmpl<tmpr)
            {
                if((str[tmpl]+index).compareTo(index+str[tmpl])>0)
                {
                    str[tmpr] = str[tmpl];
                    break;
                }
                tmpl++;
            }
        }
        str[tmpr] = index;
        fastSort(str,left,tmpl-1);
        fastSort(str,tmpr+1,right);
    }

    public static void main(String[] args) {
        Mg2020100806 mg2020100806 = new Mg2020100806();
        System.out.println(mg2020100806.minNumber(new int[]{3,30,34,5,9}));
    }

}
