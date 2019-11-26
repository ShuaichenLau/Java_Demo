package com.alice.exercise.main;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 深入理解JVM 代码清单12-1 volatile的运算
 * 2019-11-26 20:13:40
 */
public class Test01 {

    public static volatile int race = 0;
//    public static volatile AtomicInteger raceAtomicInteger = new AtomicInteger(0);

    public static void increase() {
        race++;
//        raceAtomicInteger.incrementAndGet();
    }

    public static final int THREADS_COUNT = 20;

    public static void main(String[] args) {

        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i]=new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        increase();
                    }
                }
            });

            threads[i].start();
        }
        while (Thread.activeCount() > 1){
            Thread.yield();
//            System.out.println(raceAtomicInteger);
            System.out.println(race);
        }
    }

}
