package com.alice.rabbitMQ.mqUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class HelloSender {

    private static final Logger logger = LoggerFactory.getLogger(HelloSender.class);

    @Autowired
    public AmqpTemplate amqpTemplate;

    public void send() {

        String context = "helloWorld ==>" + UUID.randomUUID().toString();
        logger.info("context==>" + context);
        this.amqpTemplate.convertAndSend("hello", context);
//        this.amqpTemplate.convertAndSend("hello", context);

        String UUIDstr  = UUID.randomUUID().toString();
        logger.info(UUIDstr);
        this.amqpTemplate.convertAndSend(UUIDstr);

    }
}
