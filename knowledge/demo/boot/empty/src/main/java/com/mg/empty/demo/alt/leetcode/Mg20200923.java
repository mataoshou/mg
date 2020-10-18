package com.mg.empty.demo.alt.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Mg20200923 {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()<=1)return s.length();
        int length=0;
        for(int i=0;i<s.length();i++)
        {
            Set set = new HashSet<>();
            for(int j=i;j<s.length();j++)
            {
                if(set.contains(s.charAt(j)))
                {
                    if(length <(j-i)) {
                        length = j - i;
                    }
                    break;
                }
                set.add(s.charAt(j));
            }
            if(length<set.size())
            {
                length=set.size();
                break;
            }
        }
        return length;
    }

    public int lengthOfLongestSubstring2(String s) {
        int length=0;
        int[] chars= new int[256];
        int index=0;
        for(int i=0;i<s.length();i++)
        {
            if(chars[s.charAt(i)]!=0)
            {
                if(length<i-index)
                {
                    length = i-index;
                }
                while(index<i)
                {
                    if(s.charAt(index)!=s.charAt(i))
                    {
                        chars[s.charAt(index)]=0;
                        index++;
                    }
                    else{
                        index++;
                        break;
                    }
                }
            }
            chars[s.charAt(i)]=1;
        }
        if((s.length()-index)>length){
            length =s.length()-index;
        }
        return length;
    }

    public static void main(String[] args) {
        Mg20200923 mg20200923 = new Mg20200923();
        mg20200923.lengthOfLongestSubstring2("abcabcbb");
    }
}
