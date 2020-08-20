package com.mg.empty.demo.mq;

import com.rabbitmq.client.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Slf4j
public class ConnectDemo {

    String exchangeName ="mgDemoExchange";
    String rountingKey ="mgRounting";
    String queueName = "mgQueue";
    String ip = "106.55.154.105";
    int port = 5672;



    public ConnectionFactory factory() {
        ConnectionFactory factory =new ConnectionFactory();
        factory.setHost(ip);
        factory.setPort(port);
        factory.setUsername("matao");
        factory.setPassword("matao");

        return factory;
    }

    public void sendMessage() throws IOException, TimeoutException {
        ConnectionFactory factory = factory();
        Connection connect = factory.newConnection();
        Channel channel= connect.createChannel();
        channel.exchangeDeclare(exchangeName,"direct"
                ,true,false,null);
        channel.queueDeclare(queueName,true,false,false,null);
        channel.queueBind(queueName,exchangeName,rountingKey);

        String message ="mgDemoMessage";

        channel.basicPublish(exchangeName,rountingKey, MessageProperties.PERSISTENT_TEXT_PLAIN,message.getBytes());
        log.info("send message:[{}]",message);
        channel.close();
        connect.close();
    }

    public void getMessage() throws IOException, TimeoutException {
        ConnectionFactory factory = factory();
//        Address address =new Address(ip,port);
        Connection connection = factory.newConnection();
        Channel channel =connection.createChannel();
        log.info("wait get");
        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                log.info("get success");
                log.info("get message:[{}]",new String(body));
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        };
        channel.basicConsume(queueName,consumer);

    }

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectDemo demo = new ConnectDemo();
        demo.sendMessage();

        demo.getMessage();
    }

}
