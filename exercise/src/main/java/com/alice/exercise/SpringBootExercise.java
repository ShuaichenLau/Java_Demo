package com.alice.exercise;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import cn.hutool.core.convert.Convert;

/**
 * Hello world!
 *
 */
@ComponentScan(basePackages = "com.alice")
@EnableAutoConfiguration
@SpringBootApplication
public class SpringBootExercise {
	public static void main(String[] args) {
 
		SpringApplication.run(SpringBootExercise.class, args);
		
	}
}
