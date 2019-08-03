package com.alice.main;

import com.alice.service.ExtInterFaceExcercise;

public class Test001 {

    public static void main(String[] args) {
        ExtInterFaceExcercise extInterFaceExcercise = (userName, Address) -> "userName:" + userName + " Address:" + Address;

        System.out.println(extInterFaceExcercise.addUser("alice", "BeiJing"));

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        }).start();

        new Thread(() -> System.out.println(Thread.currentThread().getName())).start();
    }
}
