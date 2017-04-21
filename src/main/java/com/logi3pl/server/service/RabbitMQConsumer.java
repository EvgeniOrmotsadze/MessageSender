package com.logi3pl.server.service;

import com.logi3pl.server.model.Message;
import com.logi3pl.server.utils.Configuration;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;


public class RabbitMQConsumer implements Runnable{

    private static final String EXCHANGE_NAME = "rabbit";


    public void run() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername(Configuration.USERNAME);
        factory.setPassword(Configuration.PASSWORD);
        factory.setHost(Configuration.HOSTNAME);
        factory.setPort(Configuration.PORT);
        Connection conn;
        try {
            conn = factory.newConnection();
            Channel channel = conn.createChannel();
            channel.queueDeclare(EXCHANGE_NAME, false, false, false, null);
            Consumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope,
                                           AMQP.BasicProperties properties, byte[] body)
                        throws IOException {
                    System.out.println(envelope.toString());
                    String message = new String(body, "UTF-8");
                    MemoryCache memoryCache = MemoryCache.getInstance();
                    memoryCache.putMessage(new Message(message,envelope.getDeliveryTag() + ""));
                    System.out.println("Received '" + message + "'");
                }
            };
            channel.basicConsume(EXCHANGE_NAME, true, consumer);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
