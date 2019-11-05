package com.alice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RestDemoController {

    @RequestMapping("/getMember")
    public Map<String,Object> getMember(){

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("errorCode",404);
        hashMap.put("errorTexr","404");
        return hashMap;

    }
}
