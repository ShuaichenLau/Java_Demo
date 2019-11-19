package com.alice;


import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAutoConfiguration
//@ComponentScan(basePackages = "com.alice")
@EnableAsync
@EnableAdminServer
public class Adminui {
    public static void main(String[] args) {
        SpringApplication.run(Adminui.class,args);
    }
}
