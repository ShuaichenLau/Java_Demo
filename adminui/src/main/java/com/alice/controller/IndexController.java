package com.alice.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class IndexController {


    @RequestMapping("/index")
    public String index(){
        log.info("com.alice.controller.IndexController.index");
        return "HelloWorld";
    }
}
