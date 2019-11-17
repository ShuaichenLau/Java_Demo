package com.alice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;


/**
 * @author scliuk
 * @date 2019-9-12 10:10:56
 */
//@SpringBootApplication
@ComponentScan(basePackages = {"com.alice"})
@EnableAutoConfiguration
@EnableAsync    //开启异步调用
public class BootStrap {

    public static void main(String[] args) {
        SpringApplication.run(BootStrap.class, args);
    }
}
