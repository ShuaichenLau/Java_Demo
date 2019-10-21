package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.alice")
public class Bootstrap {

    public static void main(String[] args) {

        SpringApplication.run(Bootstrap.class,args);

    }
}
