package com.alice.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class HelloSender {

    @Autowired
    public AmqpTemplate amqpTemplate;

    public void send(){
        String context = "helloWorld ==>" + LocalDateTime.now();
        System.out.println(context);
        this.amqpTemplate.convertAndSend("helloWorld",context);
    }
}
