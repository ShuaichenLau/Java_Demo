package com.alice.utils;

/**
 * RejectPolicy拒绝策略接口
 */
public interface RejectPolicy {
    void reject(Runnable task, MyThreadPoolExecutor myThreadPoolExecutor);
}