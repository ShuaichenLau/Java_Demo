package com.alice.controller;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@Slf4j
public class RestDemoController {

    @RequestMapping("/getMember")
    public Map<String,Object> getMember(){

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("errorCode",404);
        hashMap.put("errorTexr","404");
        return hashMap;

    }

    @RequestMapping("/index")
    public String index(){
        log.info("com.alice.controller.RestDemoController.index");

        return "index";
    }

    @RequestMapping("/getList")
    public List getArraylist(){
        log.info("com.alice.controller.RestDemoController.getArraylist");
        ArrayList<String> stringList = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            stringList.add(UUID.randomUUID().toString().replaceAll("-",""));
        }
        return stringList;
    }
}
