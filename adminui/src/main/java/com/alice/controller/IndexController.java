package com.alice.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

@RestController
@Slf4j
public class IndexController {

//    @RequestMapping("/")
//    public String index(){
//        log.info("com.alice.controller.IndexController.index");
//        return "admin Server";
//    }

    @RequestMapping("/time")
    public String reTime(){
        log.info("com.alice.controller.IndexController#reTime");
        return Calendar.getInstance().getTime().toString();
    }

}
