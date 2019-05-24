package com.alice.service.impl;

import com.alice.entity.User;
import com.alice.service.Uservice;

public class IUserServiceImpl implements Uservice {

    @Override
    public boolean insertUser(User user) {

        System.out.println(user.toString());

        return false;
    }
}
