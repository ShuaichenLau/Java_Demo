package com.alice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 监控中心
 */
@RestController
@Slf4j
public class IndexController {

    @RequestMapping("/indexDemo")
    public String indexController(){
        return new Date().toString();
    }
}
