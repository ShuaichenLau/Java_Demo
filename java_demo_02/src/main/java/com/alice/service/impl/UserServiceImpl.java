package com.alice.service.impl;

import com.alice.entity.User;
import com.alice.service.IUserservice;
import com.alice.spring.extannotation.ExtService;

@ExtService
public class UserServiceImpl implements IUserservice {

    @Override
    public boolean insert(User user) {
        System.out.println(user.toString());
        return false;
    }
}
