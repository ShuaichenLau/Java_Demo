package com.alice.controller;

import com.alice.entity.User;
import com.alice.service.UserServiceimpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.UUID;

@RestController
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserServiceimpl userService;

    @RequestMapping("/register")
    public String registerUser() {

        User user = new User();
        user.setId(new Random().nextInt(10));

        user.setAddress(UUID.randomUUID().toString());

        user.setName(UUID.randomUUID().toString().replaceAll("-", ""));

        user.setAge(new Random().nextInt(100));

        return userService.insertUser(user);

    }

}
