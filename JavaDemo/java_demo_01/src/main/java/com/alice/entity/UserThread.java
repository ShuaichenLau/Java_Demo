package com.alice.entity;

import java.util.List;

public class UserThread extends Thread {

    private List<UserEntity> userEntityList;

    public UserThread(List<UserEntity> userEntityList) {
        this.userEntityList = userEntityList;
    }


    @Override
    public synchronized void start() {
        for (UserEntity entity : userEntityList) {
            System.out.println("threadName:" + Thread.currentThread().getName() + " - 学员编号:" + entity.getUserId() + " - 学员名称:" + entity.getUserName());
        }
    }

//    @Override
//    public void run() {
//
//    }
}
