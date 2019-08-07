package com.alice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @RequestMapping("/")
    public String getIndex(){
        return "HelloWorld";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "Spring Boot Test Demo!";
    }
}
