package com.alice.service;

import com.alice.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserServiceimpl {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public String insertUser(User user){

        logger.info("user:{}",user.toString());

        return user.toString();
    }
}
