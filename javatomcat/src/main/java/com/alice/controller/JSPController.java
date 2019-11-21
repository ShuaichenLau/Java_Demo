package com.alice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JSPController {

    @RequestMapping("/indexDemo")
    public String jspIndex(){
        return "/indexDemo";
    }

}
