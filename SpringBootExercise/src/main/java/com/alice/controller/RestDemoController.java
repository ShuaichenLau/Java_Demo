package com.alice.controller;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

@RestController
@Slf4j
public class RestDemoController {
//    private final static Log log = LogFactory.getLog(RestController.class);

    private int xCount = 0;

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @RequestMapping("/getMember")
    public Map<String, Object> getMember() {

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("errorCode", 404);
        hashMap.put("errorTexr", "404");
        return hashMap;

    }

    @RequestMapping("/viewCount")
    public String viewCount() {
        log.info("com.alice.controller.RestDemoController.viewCount");
        int viewCount = atomicInteger.incrementAndGet();
        String result = "您已经访问了" + viewCount + "次,  当前时间是:" + new Date().toString();
        return result;
    }


    @RequestMapping("/index")
    public String index() {
        log.info("com.alice.controller.RestDemoController.index");

        System.gc();
        return "index";
    }

    @Scope("request")
    @RequestMapping("/getList")
    public List getArraylist() {
        log.info("com.alice.controller.RestDemoController.getArraylist");
        ArrayList<String> stringList = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            stringList.add(UUID.randomUUID().toString().replaceAll("-", ""));
        }

        xCount += 100;
        stringList.add(String.valueOf(xCount));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return stringList;
    }
}
