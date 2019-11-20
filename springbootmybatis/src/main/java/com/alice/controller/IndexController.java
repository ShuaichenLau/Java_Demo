package com.alice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

@RestController
public class IndexController {

    @RequestMapping("/")
    public String index(){

        return Calendar.getInstance().getTime().toString();
    }
}
