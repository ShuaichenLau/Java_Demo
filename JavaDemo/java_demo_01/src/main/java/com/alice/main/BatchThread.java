package com.alice.main;

import com.alice.entity.UserEntity;
import com.alice.entity.UserThread;
import com.alice.utils.ListUtils;
import com.google.common.collect.Lists;

import java.util.List;

public class BatchThread {

    public static void main(String[] args) {
        //初始化用户
        //定义每一个线程最多跑多少数据
        //计算每个线程数,并且计算每个线程跑哪些数据
        //让子线程进行分批异步处理数据

        List<UserEntity> userEntities = initUser();

        int userThreadPage = 50;

        List<List<UserEntity>> splitList = ListUtils.splitList(userEntities, userThreadPage);
        int userEntityThreadSize = splitList.size();

        for (int i = 0; i < userEntityThreadSize; i++) {
            List<UserEntity> userEntities1 = splitList.get(i);

            UserThread userThread = new UserThread(userEntities1);
            userThread.start();
        }


    }

    //初始化用户数据
    public static List<UserEntity> initUser() {

        List<UserEntity> userEntityArrayList = Lists.newArrayList();

        for (int i = 0; i < 100; i++) {
            userEntityArrayList.add(new UserEntity("alice" + i, i));
        }

        return userEntityArrayList;
    }


}
