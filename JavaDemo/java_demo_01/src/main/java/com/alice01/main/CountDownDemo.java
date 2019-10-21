package com.alice01.main;

import java.sql.SQLOutput;
import java.util.concurrent.CountDownLatch;

public class CountDownDemo {
    public final static CountDownLatch latch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        new Thread(){
            public void run(){
                try {
                    System.out.println("子线程1  " + Thread.currentThread().getName() + "  正在执行");
                    Thread.sleep(3000);
                    System.out.println("子线程2  " + Thread.currentThread().getName() + "  正在执行");
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread(){
            public void run(){
                try {
                    System.out.println("子线程3  " + Thread.currentThread().getName() + "  正在执行");
                    Thread.sleep(3000);
                    System.out.println("子线程4  " + Thread.currentThread().getName() + "  正在执行");
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        System.out.println("等待2个子线程执行完毕");
        latch.await();
        System.out.println("2个子线程执行完毕");
        System.out.println("执行主线程");


    }
}
