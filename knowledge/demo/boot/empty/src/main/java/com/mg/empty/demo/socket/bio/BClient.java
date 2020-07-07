package com.mg.empty.demo.socket.bio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

@Slf4j
public class BClient {

    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("127.0.0.1",1820);
        OutputStream outputStream = socket.getOutputStream();

        while(true) {
            Thread.sleep(1000);
            log.info("begin send word!!");
            outputStream.write(("mg" + System.currentTimeMillis()).getBytes());
        }
    }

}
