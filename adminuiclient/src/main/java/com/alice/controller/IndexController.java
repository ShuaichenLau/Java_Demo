package com.alice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class IndexController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/")
    public String welcome(){
        return new Date().toString();
    }

}
