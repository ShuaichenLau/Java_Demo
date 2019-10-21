package com.alice01.main;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantLockDemo implements RejectedExecutionHandler {
    public static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    public static void main(String[] args) {

        //读写锁
//        ReentrantReadWriteLock.ReadLock readLock = new ReentrantReadWriteLock.ReadLock().lock();
//        new ReentrantReadWriteLock.WriteLock().lock();

        try {
            lock.lock();
            condition.wait();
            condition.signal();
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "==>" + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }

    //内置拒绝策略
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
    }
}
