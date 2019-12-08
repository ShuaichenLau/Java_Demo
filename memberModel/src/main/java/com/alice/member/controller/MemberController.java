package com.alice.member.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/member")
public class MemberController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/memberIndex")
    public Map<String,Object> memberIndex(){
        logger.info("com.alice.member.controller.MemberController.memberIndex");
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code","200");
        map.put("message","memberIndex");
        map.put("time", Calendar.getInstance().getTime().toString());

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return map;
    }

}
