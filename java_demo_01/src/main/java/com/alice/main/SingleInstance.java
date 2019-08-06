package com.alice.main;

/**
 * 双重校验锁
 * @author liusc
 */
public class SingleInstance {

    public static volatile SingleInstance singleInstance = null;

    private SingleInstance() {
    }

    public static SingleInstance getInstance() {

        if (singleInstance == null) {
            synchronized (SingleInstance.class) {
                if (singleInstance == null) {
                    singleInstance = new SingleInstance();
                }
            }
        }

        return singleInstance;
    }
}
