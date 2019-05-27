package com.alice.controller;

import com.alice.spring.extannotation.ExtController;
import com.alice.spring.extannotation.ExtRequestMapping;

@ExtController
@ExtRequestMapping("/ext")
public class ExtIndexController {

    @ExtRequestMapping("/test")
    public String index(){
        System.out.println("手写SpringMVC框架");
        return "index";
    }

}