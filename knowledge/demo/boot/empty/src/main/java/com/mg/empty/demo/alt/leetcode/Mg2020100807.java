package com.mg.empty.demo.alt.leetcode;

public class Mg2020100807 {

    public String reverseWords(String s) {
        String[] strs = s.split(" ");

        String result ="";
        for(int i=0;i<strs.length;i++)
        {
            if(strs[i].length()==0)
            {
                continue;
            }

            if(result.length()>0)result =" " +result;
            result = strs[i]  +result;
        }
        return result;
    }


}
