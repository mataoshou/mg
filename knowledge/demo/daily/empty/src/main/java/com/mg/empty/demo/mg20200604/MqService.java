package com.mg.empty.demo.mg20200604;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class MqService {

    public static void main(String[] args) throws Exception {
//        throw  new Exception(".....");
        ConnectionFactory factory =new ConnectionFactory();
        factory.setHost("10.0.127.103");
        factory.setPort(5672);
        factory.setUsername("matao");
        factory.setPassword("matao");
        Connection connection = factory.newConnection();

        Channel channel = connection.createChannel();
        channel.exchangeDeclare("mg_exchange","direct",true,false,null);
        channel.queueDeclare("mg_queue",true,false,false,null);
        channel.queueBind("mg_queue","mg_exchange","mg");

        for(int i=0;i<10;i++) {
            channel.basicPublish("mg_exchange", "mg", MessageProperties.PERSISTENT_TEXT_PLAIN,
                    ("Hello"+System.currentTimeMillis()).getBytes());
            Thread.sleep(1000);
        }

        Thread.sleep(1000*30);

        channel.close();

    }
}
