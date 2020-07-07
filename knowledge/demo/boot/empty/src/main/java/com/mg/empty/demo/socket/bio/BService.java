package com.mg.empty.demo.socket.bio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

@Slf4j
public class BService implements Runnable{

    public static void createService() throws IOException {
        ServerSocket serverSocket = new ServerSocket(1820);

        while(true) {
            Socket socket = serverSocket.accept();
            BService service = new BService(socket);
            Thread thread = new Thread(service);
            thread.start();
        }
    }

    public BService(Socket socket)
    {
        this.mysocket = socket;
    }

    Socket mysocket;

    @Override
    public void run() {
        try {
            log.info("begin");
            InputStream inputStream = mysocket.getInputStream();
            byte[] bs = new byte[1024*10];


            while(true)
            {
                int no = inputStream.read(bs);
                log.info("{}",new String(bs,0,no));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        try {
            createService();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
