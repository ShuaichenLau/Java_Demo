package com.alice.utils;

/**
 * DiscardRejectPolicy丢弃策略实现类
 * 丢弃当前任务
 */
public class DiscardRejectPolicy implements RejectPolicy {
    @Override
    public void reject(Runnable task, MyThreadPoolExecutor myThreadPoolExecutor) {
        // do nothing
        System.out.println("discard one task");
    }
}