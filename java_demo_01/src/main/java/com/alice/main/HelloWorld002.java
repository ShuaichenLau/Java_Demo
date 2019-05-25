package com.alice.main;

import com.alice.service.Uservice;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorld002 {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring2.xml");
        System.out.println("==============================================================");
        Uservice userService = (Uservice) applicationContext.getBean("userService");
        System.out.println(userService);

    }
}
