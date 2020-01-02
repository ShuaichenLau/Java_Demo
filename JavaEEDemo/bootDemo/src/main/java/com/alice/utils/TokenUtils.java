package com.alice.utils;


import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 防止token重复提交
 * 1.表示是一个临时不允许有重复相同的值(临时且唯一)
 * 2.使用令牌方式防止Token重复提交
 * 使用场景:在调用API接口的时候,需要传递令牌,该API接口获取到令牌之后,执行当前业务逻辑.然后再把当前令牌删除
 * 在调用API接口的时候,需要传递令牌,建议1.5小时 2小时
 */
public class TokenUtils {

    //代码步骤

    //1.获取令牌

    //2.判断令牌是否在缓存中有对应的数据

    //3.如果缓存中没有该令牌,直接报错(请勿重复提交)

    //4.如果缓存有该令牌,直接执行该业务逻辑

    //5.执行完成业务逻辑之后,直接删除该令牌

    private final static Map<String, Object> tokenMaps = new ConcurrentHashMap<String, Object>();

    /**
     * 获取令牌
     *
     * @return
     */
    public static synchronized String getToken() {
        // 如何在分布式场景下使用分布式全局ID实现
        String token = "token" + System.currentTimeMillis();
        // hashMap好处是可以附带
        tokenMaps.put(token, token);
        return token;
    }

    public static boolean findToken(String token) {
        // 判断该令牌是否存在tokenMap是否存在
        String tokenMap = (String) tokenMaps.get(token);
        if (StringUtils.isEmpty(tokenMap)) {
            return false;
        }
        //token获取成功之后 remove token
        tokenMaps.remove(token);
        return true;
    }
}
