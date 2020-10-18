package com.mg.empty.demo.alt.leetcode;

import java.util.HashSet;

public class Mg2020100805 {

    String root ="";
    HashSet<String> set = new HashSet<>();
    public String[] permutation(String s) {
        root=s;
        dfs(0,"",root);
        String[] result = new String[set.size()];
        return set.toArray(result);
    }

    public void dfs(int index,String base,String remain)
    {
        if(index==root.length())
        {
            if(!set.contains(base))
            {
                set.add(base);
            }
            return;
        }

        for(int i=0;i<remain.length();i++)
        {
            String tmp = remain.substring(0,i)+remain.substring(i+1,remain.length());
            String tmpBase = base+remain.charAt(i);
            dfs(index+1,tmpBase,tmp);
        }
    }

    public static void main(String[] args) {
        Mg2020100805 mg2020100805 = new Mg2020100805();
        String[] result = mg2020100805.permutation("abc");

        for(String str : result)
        {
            System.out.println(str);
        }
    }
}
