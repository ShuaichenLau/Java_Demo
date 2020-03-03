package com.alice.service;

import com.alice.exercise.component.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TokenService {
    @Autowired
    private RedisService redisService;

    // 新增 返回token
    public String put(Object object) {
        String token = getToken();
        redisService.setString(token, object);
        return token;
    }

    // 获取信息
    public String get(String token) {
        String reuslt = redisService.getString(token);
        return reuslt;
    }

    public String getToken() {
        return UUID.randomUUID().toString();
    }

}
