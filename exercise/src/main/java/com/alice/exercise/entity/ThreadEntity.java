package com.alice.exercise.entity;

import java.util.Calendar;

public class ThreadEntity implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println(Calendar.getInstance().getTime().toString());
            Thread.sleep(100000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
