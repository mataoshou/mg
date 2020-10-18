package com.mg.empty.demo.alt.leetcode;

public class Mg2020092502 {
    public int myAtoi(String str) {
        int result =0;
        int status =0;
        int symbol =1;
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)>'9'||str.charAt(i)<'0')
            {
                if(status==1)return result*symbol;
                if(str.charAt(i)==' ')continue;
                else if(str.charAt(i)=='+'){status=1;continue;}
                else if(str.charAt(i)=='-'){symbol*=-1;status=1;continue;}
                else {
                    break;
                }
            }
            status =1;
            int index =str.charAt(i)-48;
            if(result*symbol>Integer.MAX_VALUE/10||(
                    result*symbol==Integer.MAX_VALUE/10 &&index>7
                    ))return Integer.MAX_VALUE;
            if(result*symbol<Integer.MIN_VALUE/10||(
                    result*symbol==Integer.MIN_VALUE/10 &&index>8
            ))return Integer.MIN_VALUE;
            result=(result*10+index);
        }
        return result*symbol;
    }

    public static void main(String[] args) {
        Mg2020092502 mg2020092502= new Mg2020092502();
        System.out.println(mg2020092502.myAtoi("  -0012a42"));
    }
}
