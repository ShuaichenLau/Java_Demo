package com.mashibing.juc.c_021_02_AQS;

import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;

public class Main {
    public static int m = 0;
    public static Lock lock = new MLock();


    public static void main(String[] args) throws Exception {

        long startTime = System.currentTimeMillis();


        Thread[] threads = new Thread[100];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {

//                synchronized (Main.class){
//                    for (int j = 0; j < 10000; j++) m++;
//                }


                try {
                    lock.lock();
//                    lock.tryLock();
                    for (int j = 0; j < 100; j++) m++;
//                    System.out.println(Thread.currentThread().getName());
                } finally {
                    lock.unlock();
                }
            });
        }

        for (Thread t : threads) t.start();

        for (Thread t : threads) t.join();

        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime + "  time");

        System.out.println(m);


        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();

//        Maps.synchronizedBiMap(objectObjectHashMap);
//        Maps.synchronizedNavigableMap(objectObjectHashMap);

        ArrayList<Object> objects = new ArrayList<>();
        Collections.synchronizedList(objects);
        Collections.synchronizedMap(objectObjectHashMap);

        ConcurrentHashMap<Object, Object> objectObjectConcurrentHashMap = new ConcurrentHashMap<>();


        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(Runtime.getRuntime().totalMemory());
        System.out.println(Runtime.getRuntime().freeMemory());
        System.out.println(Runtime.getRuntime().maxMemory());
        Runtime.getRuntime().gc();

        System.out.println(Thread.currentThread().getName());
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(10);

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });


        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 5, 10, TimeUnit.SECONDS, arrayBlockingQueue);

        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });

        threadPoolExecutor.shutdown();
        executorService.shutdown();


    }
}