package com.mg.empty.demo.alt.leetcode;

public class Mg2020100804 {

    public boolean isMagic(int[] target) {
        int length = target.length-1;

        int index = 0;

        int[] arrays = new int[target.length];

        for(int i=0;i<arrays.length;i++)
        {
            arrays[i] =i+1;
        }


        int k=0;
        int[] tmp = new int[target.length];
        while(index<=length) {
            int middle = (length-index+1)/2;
            for (int i = 0; i < tmp.length; i++) {
                if((i)%2==1) {
                    tmp[i / 2] = arrays[i+k];
                }
                if((i)%2==0)
                {
                    tmp[i/2 + middle]=arrays[i+k];
                }
            }

            if(k==0) {
                k = tmp[index];
            }

            for(int i=0;i<k&&index<=length;i++)
            {
                if(tmp[i]!=target[index])return false;
                index++;
            }
            arrays = tmp;
            tmp = new int[length-index+1];
        }
        return true;

    }

    public static void main(String[] args) {
        Mg2020100804 mg2020100804 = new Mg2020100804();
        System.out.println(mg2020100804.isMagic(new int[]{2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,42,44,46,48,50,52,54,56,58,60,62,64,66,68,1,3,5,7,9,11,13,15,17,19,21,23,25,27,29,31,33,35,37,39,41,43,45,47,49,51,55,59,63,67,53,57,61,65,69}));
    }

}
