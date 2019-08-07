package com.alice.rabbitMQ.controller;

import com.alice.rabbitMQ.entity.User;
import com.alice.rabbitMQ.mqUtils.HelloSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class HelloWorldController {

    private static final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

    @Autowired
    private HelloSender helloSender;


    @RequestMapping("/")
    public String index() {

        for (int i = 0; i < 1000; i++) {

            User user = new User();
            user.setId(UUID.randomUUID().toString());
            user.setName("alice");
            user.setAddress("beijing");
            user.setAge(25);

            helloSender.send();

            helloSender.amqpTemplate.convertAndSend("alice", user.toString());
        }
        
        
        return "HelloWorld";
    }

    @RequestMapping("/getUser")
    public String getUser() {

        logger.info("com.alice.rabbitMQ.controller.HelloWorld.getUser");

        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setName("alice");
        user.setAddress("beijing");
        user.setAge(25);

        helloSender.send();

        helloSender.amqpTemplate.convertAndSend("alice", user.toString());


        return user.toString();
    }
}
