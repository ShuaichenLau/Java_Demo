package com.alice.main;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁
 */
public class SpinLock {

    private AtomicReference<Thread> sign = new AtomicReference<>();

    public void lock(){
        Thread thread = Thread.currentThread();
        while (!sign.compareAndSet(null,thread)){

        }
    }

    public void unLock(){
        Thread thread = Thread.currentThread();
        sign.compareAndSet(thread,null);
    }
}
