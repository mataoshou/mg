package com.mg.empty.demo.socket.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Random;

public class NClient {
    public static void main(String[] args) {
        InetSocketAddress address = new InetSocketAddress("127.0.0.1",1820);
        SocketChannel sc =null;
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        Random random = new Random();
        int ranInt = random.nextInt();

        try{
            sc = SocketChannel.open();
            sc.connect(address);
            while(true){
                byte[] bytes = ("mg###" +ranInt +"###" +Thread.currentThread().getName() +"###" + System.currentTimeMillis()).getBytes();
                buffer.put(bytes);
                buffer.flip();
                sc.write(buffer);
                buffer.clear();
            }
        }catch( IOException e){
            e.printStackTrace();
        }finally {
            if(sc!=null){
                try {
                    sc.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
