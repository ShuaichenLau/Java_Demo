package com.alice;

import com.sun.org.apache.bcel.internal.generic.GETSTATIC;
import com.sun.org.apache.bcel.internal.generic.INVOKESTATIC;
import com.sun.org.apache.bcel.internal.generic.PUTSTATIC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
//@EnableAutoConfiguration
//@EnableAsync
//@ComponentScan("com.alice")
public class SpringBootExercise {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootExercise.class,args);
        GETSTATIC.getComparator();
        PUTSTATIC.getComparator();
        INVOKESTATIC.getComparator();
    }
}