package com.alice.exercise.controller;

import com.alice.exercise.component.MapCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cache")
public class CacheController {

    @Autowired
    private MapCache mapCache;


    @RequestMapping("/get")
    public Object get(String key) {
        return mapCache.get(key);
    }

    @RequestMapping("/put")
    public String put(String key, String value) {
        try {
            mapCache.put(key, value);
            return "success";
        } catch (Exception e) {
            return e.toString();
        }
    }

    @RequestMapping("/remove")
    public String remove(String key) {
        try {
            mapCache.remove(key);
            return "success";
        } catch (Exception e) {
            return e.toString();
        }
    }


}
