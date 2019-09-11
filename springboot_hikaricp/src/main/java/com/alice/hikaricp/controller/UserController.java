package com.alice.hikaricp.controller;

import com.alice.hikaricp.entity.User;
import com.alice.hikaricp.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/user")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    private AtomicInteger atomicInteger = new AtomicInteger();

    @RequestMapping("/add")
    public String insertUser(){

        User user = new User();
        user.setUserName("alice" + atomicInteger.decrementAndGet());
        user.setPassword(UUID.randomUUID().toString().replaceAll("-",""));
        user.setPhone("17610071080");

        userService.insertUser(user);
        return user.toString();
    }

}
