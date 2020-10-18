package com.mg.empty.demo.alt.leetcode;

import sun.security.util.Length;

import java.util.logging.Level;

public class Mg2020092505 {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0)return "";
        if(strs.length==1)return strs[0];;
        String result ="";
        int length = strs[0].length();
        for(int j=0;j<length;j++)
        {
            char schar = strs[0].charAt(j);
            for (int i=0;i<strs.length;i++)
            {
                if(strs[i].length()<=j||schar!=strs[i].charAt(j))
                {
                    return result;
                }
            }
            result +=schar;
        }
        return result;
    }

    public String longestCommonPrefix2(String[] strs) {
        if(strs==null||strs.length==0)return "";
        if(strs.length==1)return strs[0];;
        String result =strs[0];
        for(int i=0;i<strs.length;i++)
        {
            if(strs[i].equals(result))continue;
            int j=0;
            for(;j<strs[i].length()&&j<result.length();j++)
            {

                if(strs[i].charAt(j)!=result.charAt(j))
                {
                    break;
                }
            }
            if(j==0)return "";
            result = result.substring(0,j);
        }
        return result;
    }

    public static void main(String[] args) {
        Mg2020092505 mg2020092505 = new Mg2020092505();
        System.out.println(mg2020092505.longestCommonPrefix2(new String[]{
                "","b"
        }));
    }
}
