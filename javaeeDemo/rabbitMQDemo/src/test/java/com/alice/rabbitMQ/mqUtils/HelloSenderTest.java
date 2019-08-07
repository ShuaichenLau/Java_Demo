package com.alice.rabbitMQ.mqUtils;

import com.alice.Bootstrap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Bootstrap.class)
public class HelloSenderTest {

    @Autowired
    private HelloSender helloSender;

    @Test
    public void test() {
        helloSender.send();
    }
}