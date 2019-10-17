package com.alice.controller;

import com.alice.spring.extannotation.ExtController;
import com.alice.spring.extannotation.ExtRequestMapping;

import java.util.concurrent.atomic.AtomicInteger;


@ExtController
@ExtRequestMapping("/hi")
public class HelloWorldController {

    @ExtRequestMapping("/test")
    public String index(){
        System.out.println("手写SpringMVC框架");
        return "helloWorld";
    }


    public static void main(String[] args) {
        int i = 10;

        AtomicInteger atomicInteger = new AtomicInteger(5);

    }

}
