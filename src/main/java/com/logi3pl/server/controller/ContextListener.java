package com.logi3pl.server.controller;

import com.logi3pl.server.service.RabbitMQConsumer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class ContextListener implements ServletContextListener {

    /**
     * Default constructor.
     */

    public ContextListener() {}

    //when initial java context first start RabbitConsumers for listen to publisher
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        RabbitMQConsumer producer = new RabbitMQConsumer();
        new Thread(producer).start();
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
