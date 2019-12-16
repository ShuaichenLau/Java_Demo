package com.alice.api;

import com.google.common.util.concurrent.RateLimiter;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Aspect
@Component
public class RateLimiterAop {

    // 存放接口是否已经存在
    private static ConcurrentHashMap<String, RateLimiter> rateLimiterMap = new ConcurrentHashMap<String, RateLimiter>();

}
