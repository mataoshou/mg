package com.mg.empty.demo.alt.leetcode;

import groovy.lang.MetaClassImpl;

public class Mg20200924 {
    public String convert(String s, int numRows) {
        if(numRows==1)return s;
        char[] chars = new char[s.length()];
        int row=0;
        int interval = numRows*2-2;
        int middle =0;
        int no =0;
        for(int i=0;i<numRows;i++)
        {
            middle = interval-i;
            row=0;
            int index=0;
            while(no<s.length()&&index<s.length())
            {
                index=(interval * row);
                if(index+i <s.length()) {
                    chars[no] = s.charAt(index + i);
                    no++;
                }
                if(i>0&&i<(numRows-1)) {
                    if((index + middle)<s.length()){
                        chars[no] = s.charAt(index + middle);
                        no++;
                    }
                }
                row++;
            }

        }
        String result =new String(chars);
        return  result;
    }

    public String convert2(String s, int numRows) {
        if(numRows==1)return s;
        char[] chars = new char[s.length()];
        int interval = numRows*2-2;
        int middle =0;
        int no =0;
        for(int i=0;i<numRows;i++)
        {
            middle = 2*i;
            int index=i;
            while(no<s.length()&&index<s.length())
            {
                if(index <s.length()) {
                    chars[no] = s.charAt(index);
                    no++;
                }
                if(i==0||i==numRows-1) {
                    index +=interval;
                }
                else {
                    middle = interval - middle;
                    index += middle;
                }

            }

        }
        String result =new String(chars);
        return  result;
    }


    public static void main(String[] args) {
        Mg20200924 mg20200924=new Mg20200924();
            System.out.println(mg20200924.convert2(
                    "PAYPALISHIRING",
                    4));
    }
}
