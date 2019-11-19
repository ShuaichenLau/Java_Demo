package com.alice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class AdminUiClient {

    public static void main(String[] args) {
        SpringApplication.run(AdminUiClient.class, args);
    }
}
