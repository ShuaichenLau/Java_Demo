package com.alice.rabbitMQ.mqUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

/**
 * RabbitMQ 配置类
 */
@Configuration
public class RabbitConfig {
    private final Logger logger = LoggerFactory.getLogger(RabbitConfig.class);


    @Bean
    public Queue queue(){
        Queue queue = new Queue("alice");
        queue.isDurable();
        logger.info(queue.getName());
        return queue;
    }
}