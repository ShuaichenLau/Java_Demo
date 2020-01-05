package com.alice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 监控中心
 */
@RestController
@Slf4j
@Scope("request")   //SpringMVC 多例
public class IndexController {

    @RequestMapping("/indexDemo")
    public String indexController(){
        log.info("com.alice.controller.IndexController.indexController");

        new CopyOnWriteArrayList<String>();
        new ArrayList<String>();
        new HashMap<String,String>();

        System.out.println(1 << 4);

        Calendar calendar = Calendar.getInstance();

        return calendar.getTime().toString();
//        return new Date().toString();


    }
}
