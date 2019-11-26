package com.alice.controller;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
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
        String now = DateUtil.now();
        return "纯手写SpringBoot ...." + Convert.toDate(now);
    }
}
