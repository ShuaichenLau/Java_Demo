package com.alice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * SpringBoot 整合 pageHelper
 */
@EnableAsync
@SpringBootApplication
public class SpringBootMybatisDemo {

    public static void main(String[] args) {

        SpringApplication.run(SpringBootMybatisDemo.class,args);
    }
}
