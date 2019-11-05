package com.alice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan("com.alice")
public class SpringBootExercise {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootExercise.class,args);
    }
}
