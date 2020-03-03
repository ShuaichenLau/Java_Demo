package com.alice.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class SessionTestController {

    @RequestMapping("/session")
    public String sessionTestIndex(HttpServletRequest request, String name) {

        HttpSession session = request.getSession();

        System.out.println(session.getId());
        System.out.println(session.getCreationTime());

        System.out.println(session.getAttribute("name"));
        return "sessionId = " + session.getId() + " ,name = " + name;

    }
}
