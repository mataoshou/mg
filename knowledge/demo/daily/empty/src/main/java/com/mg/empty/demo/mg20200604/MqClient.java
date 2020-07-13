package com.mg.empty.demo.mg20200604;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class MqClient {

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        ConnectionFactory factory =new ConnectionFactory();
        factory.setHost("10.0.127.103");
        factory.setPort(5672);
        factory.setUsername("matao");
        factory.setPassword("matao");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.basicQos(64);

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("....." + new String(body));

                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        };

        channel.basicConsume("mg_queue",consumer);

        Thread.sleep(1000*30);

    }
}
