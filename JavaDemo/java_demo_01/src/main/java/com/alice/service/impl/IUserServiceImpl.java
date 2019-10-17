package com.alice.service.impl;

import com.alice.entity.User;
import com.alice.service.Uservice;


public class IUserServiceImpl implements Uservice {

    public IUserServiceImpl() {
        System.out.println("com.alice.service.impl.IUserServiceImpl ============  无参构造");
    }

    @Override
    public boolean insertUser(User user) {

        System.out.println(user.toString());

        return false;
    }
}
