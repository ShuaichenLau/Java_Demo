package com.alice.rabbitMQ.mqUtils;

import com.alice.Bootstrap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Bootstrap.class)
public class HelloSenderTest {

    @Autowired
    private HelloSender helloSender;

    @Test
    public void test() {
        helloSender.amqpTemplate.convertAndSend("liusc", UUID.randomUUID().toString());
        helloSender.send();

    }
}