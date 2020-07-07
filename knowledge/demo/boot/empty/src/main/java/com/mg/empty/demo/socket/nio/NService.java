package com.mg.empty.demo.socket.nio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;

@Slf4j
public class NService {

    public void startService() throws IOException {
        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.configureBlocking(false);
        ServerSocket serverSocket = channel.socket();
        serverSocket.bind(new InetSocketAddress(1820));
        Selector selector = Selector.open();

        channel.register(selector, SelectionKey.OP_ACCEPT);
        waitMessage(selector);
    }

    public void waitMessage(Selector selector) throws IOException {
        while(true)
        {
            ByteBuffer readBuffer = ByteBuffer.allocateDirect(1024);
            if(selector.select()>0)
            {
//                log.info("....就绪数量： " +no);
//                int readyno =  selector.readyOps();
                Iterator<SelectionKey> iterator= selector.selectedKeys().iterator();
                while(iterator.hasNext())
                {
                    SelectionKey selectionKey = iterator.next();
                    iterator.remove();
                    log.info(selectionKey.toString());
                    log.info("service begin");
                    if (selectionKey.isAcceptable()) {// 客户端请求连接事件
                        log.info("service accept");
                        ServerSocketChannel server = (ServerSocketChannel) selectionKey.channel();
                        // 获得和客户端连接的通道
                        SocketChannel channel = server.accept();
                        if(channel!=null) {
                            // 设置成非阻塞
                            channel.configureBlocking(false);
                            // 在和客户端连接成功之后，为了可以接收到客户端的信息，需要给通道设置读的权限。
                            channel.register(selector, SelectionKey.OP_READ);
                        }

                    }
                    if (selectionKey.isReadable()) {// 获得了可读的事件
                        log.info("service read");
                        read(selectionKey);
                    }
                }
            }
        }
    }

    public void read(SelectionKey key) throws IOException {
        // 服务器可读取消息:得到事件发生的Socket通道
        SocketChannel channel = (SocketChannel) key.channel();
        // 创建读取的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(512);
        channel.read(buffer);
        byte[] data = buffer.array();
        String msg = new String(data).trim();
        System.out.println(key.toString()+"服务端收到信息：" + msg);
//        ByteBuffer outBuffer = ByteBuffer.wrap(msg.getBytes("utf-8"));
//        channel.write(outBuffer);// 将消息回送给客户端
    }
    public static void main(String[] args) throws IOException {
        NService service = new NService();
        service.startService();
    }
}
