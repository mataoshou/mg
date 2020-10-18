package com.mg.empty.demo.alt.leetcode;

public class Mg2020092302 {
    public String longestPalindrome(String s) {
        if(s.length()==1)return s;
        String result ="";
        int index =0;
        int left=0;
        int right=0;

        for(int i=0;i<s.length()-1;i++)
        {
            String str1 = getPStr(s,i,i);
            String str2 = getPStr(s,i,i+1);
            result=str1.length()>result.length()?str1:result;
            result=str2.length()>result.length()?str2:result;
        }

        return result;
    }

    public String getPStr(String s,int left,int right)
    {
        while(left>=0&&right<s.length()){
            if(s.charAt(left)==s.charAt(right))
            {
                left--;right++;
            }
            else break;
        }
        return s.substring(left+1,right);
    }

    public static void main(String[] args) {
        Mg2020092302 mg2020092302 = new Mg2020092302();
        System.out.println(mg2020092302.longestPalindrome("a"));
    }
}
