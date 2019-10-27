package com.alice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ResponseBody 和 @Controller 的组合注解
 */
@RestController
public class HelloWorldController {

    @RequestMapping("/index")
    public String index(){
        return "HelloWorld";
    }
}
