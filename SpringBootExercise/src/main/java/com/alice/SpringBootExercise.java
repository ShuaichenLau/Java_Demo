package com.alice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
//@EnableAutoConfiguration
@EnableAsync
//@ComponentScan("com.alice")
public class SpringBootExercise {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootExercise.class,args);
    }
}
