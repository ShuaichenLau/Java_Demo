package com.alice01.classTest;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {


        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " 上自习结束 离开教室");
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }
        countDownLatch.await();

        //Thread.sleep(1000);

        new Thread(() -> {
            System.out.println("班长关灯锁门......");
            System.out.println(Integer.MAX_VALUE);
        }).start();

    }
}
