package com.alice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync    //启动异步任务
public class AdminUiClient {

    public static void main(String[] args) {
        SpringApplication.run(AdminUiClient.class, args);
    }
}
