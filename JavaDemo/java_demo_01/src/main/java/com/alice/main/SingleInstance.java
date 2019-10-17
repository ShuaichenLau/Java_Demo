package com.alice.main;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 双重校验锁
 *
 * @author liusc
 */
public class SingleInstance {

    public static volatile SingleInstance singleInstance = null;

    public static ResLock resLock = new ResLock();

    private SingleInstance() {
    }

    public static SingleInstance getInstance() {

        if (singleInstance == null) {
            resLock.lock.lock();
//        synchronized (SingleInstance.class) {
            if (singleInstance == null) {
                singleInstance = new SingleInstance();
            }
//        }
            resLock.lock.unlock();
        }

        return singleInstance;
    }
}


class ResLock {

    public Lock lock = new ReentrantLock();

    public String userName;
    public String userSex;

    public boolean flag = false;


}