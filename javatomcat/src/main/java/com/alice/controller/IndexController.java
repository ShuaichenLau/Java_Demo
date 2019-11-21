package com.alice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

/**
 * RestController 是SpringMVC提供的
 */
@RestController
public class IndexController {

    @RequestMapping(value = "/index", produces = "text/html;charset=UTF-8")
    public String index(){
        return "纯手写SpringBoot ...." + Calendar.getInstance().getTime().toString();
    }
}
