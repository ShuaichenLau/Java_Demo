package com.alice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 监控中心
 */
@RestController
@Slf4j
@Scope("request")   //SpringMVC 多例
public class IndexController {

    @RequestMapping("/indexDemo")
    public String indexController(){
        return new Date().toString();
    }
}
