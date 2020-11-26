package com.mg.empty.demo.alt.leetcode;

public class Mg2020100803 {
    public int calculate(String s) {

        int x=1;
        int y=0;
        for(int i=0;i<s.length();i++) {
            switch (s.charAt(i)) {
                case 'A':x = 2 * x + y;break;
            }
        }
        return x+y;
    }

    public static void main(String[] args) {
        Mg2020100803 mg2020100803 = new Mg2020100803();
        System.out.println(mg2020100803.calculate("AB"));
    }
}
