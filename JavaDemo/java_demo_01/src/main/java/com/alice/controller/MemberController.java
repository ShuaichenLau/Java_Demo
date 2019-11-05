package com.alice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MemberController {

    @RequestMapping("/getMember")
    public Map<String, Object> getMember() {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("errorCode",200);
        hashMap.put("errorMsg","alice");
        return hashMap;
    }
}
