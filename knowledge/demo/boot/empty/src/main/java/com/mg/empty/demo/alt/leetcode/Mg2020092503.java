package com.mg.empty.demo.alt.leetcode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Mg2020092503 {
    public boolean isPalindrome(int x) {
        if(x<0)return false;
        if(x<10)return true;

        int right = x;
        int left = 0;
        while(right>left)
        {
            int index = right%10;
            right = right/10;
            if(right==left)return true;
            left = left*10 + index;
            if(right==left)return true;
            if(left==0)return false;
        }
        return false;
    }

    public static void main(String[] args) {
        Mg2020092503 mg2020092503 = new Mg2020092503();
        log.info("{}",mg2020092503.isPalindrome(10));
    }

}
