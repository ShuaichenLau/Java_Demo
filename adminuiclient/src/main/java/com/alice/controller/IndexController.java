package com.alice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sound.midi.Soundbank;
import java.util.Calendar;
import java.util.Date;

@RestController
public class IndexController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/")
    public String welcome(){
        return Calendar.getInstance().getTime().toString();
    }

}
