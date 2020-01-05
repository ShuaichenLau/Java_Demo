package com.alice.utils;

/**
 * 生成token
 */
public class RedisToken {


    public String getToekn() {
        String token = "token_" + System.currentTimeMillis();
        return token;
    }
}
