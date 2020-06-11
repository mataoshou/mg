package com.mg.empty.demo.mg20200605;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class DirectDemo {
    public static void main(String[] args) {
        List<ByteBuffer> list = new ArrayList<ByteBuffer>();
        while(true)
        {
            list.add(ByteBuffer.allocateDirect(1000*5));
        }
    }
}
