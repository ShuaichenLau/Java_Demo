package com.alice.exercise;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

import cn.hutool.core.convert.Convert;

/**
 * Hello world!
 * @author scliuk
 * 2019-11-26 10:01:09
 *
 */
@ComponentScan(basePackages = "com.alice")
@EnableAutoConfiguration
@EnableAsync
public class SpringBootExercise {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootExercise.class, args);

		System.gc();
		Runtime.getRuntime().gc();
		
	}
}
