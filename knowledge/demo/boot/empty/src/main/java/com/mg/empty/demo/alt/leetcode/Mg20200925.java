package com.mg.empty.demo.alt.leetcode;

public class Mg20200925 {
    public int reverse(int x) {
        if(x==0)return x;
        Long result =0L;
        int index=0;
        while(x!=0)
        {
            index= x%10;
            x =x/10;
            result = result*10 + index;
        }
        if(result>Integer.MAX_VALUE||result<Integer.MIN_VALUE)return 0;
        return result.intValue();
    }

    public static void main(String[] args) {
        Mg20200925 mg20200925 =new Mg20200925();
        System.out.println(mg20200925.reverse(1534236469));
    }
}
