package com.alice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableAutoConfiguration
//@ComponentScan("com.alice")
public class Bootstrap {

    public static void main(String[] args) {
        SpringApplication.run(Bootstrap.class,args);
    }
}
