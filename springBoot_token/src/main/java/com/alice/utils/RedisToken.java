package com.alice.utils;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.FastByteArrayOutputStream;
import org.springframework.util.StringUtils;

import java.util.UUID;

@Component
public class RedisToken {

    @Autowired
    private BaseRedisService baseRedisService;

    private static final Long TIMEOUT = 60 * 60L;

    public static String getAccessToken(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    public String getToken() {
        // 生成token 规则保证 临时且唯一 不支持分布式场景 分布式全局ID生成规则
        String token = "token_" + UUID.randomUUID();
        baseRedisService.setString(token, token, TIMEOUT);
        return token;
    }

    /**
     * 如何使用token解决幂等性
     * 1.在调用接口之前生成对应的令牌 存放在redis
     * 2.调用接口的时候,将该令牌放入请求头中
     * 3.接口获取对应的令牌,如果能够获取到该令牌,就能执行该方法的业务逻辑
     * 4.接口获取到对应的令牌,如果获取不到该令牌,直接返回请勿重复提交
     */

    public boolean findToken(String token) {
        if (StringUtils.isEmpty(token)) {
            return false;
        }

        String tokenValue = (String) baseRedisService.getString(token);
        if (StringUtils.isEmpty(tokenValue)) {
            return false;
        }

        //保证每个接口对应的token 只能访问一次 保证接口幂等性问题
        baseRedisService.delKey(tokenValue);
        return true;
    }
}
