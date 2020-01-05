package com.alice.controller;

import com.alice.utils.RedisToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;

/**
 * @author liusc
 * 2020-1-4 19:50:12
 */
@RestController
public class TokenDemoController {

    @Autowired
    private RedisToken redisToken;

    @RequestMapping("/")
    public String index() {
        String token = redisToken.getToken();
        return Calendar.getInstance().getTime().toString() + "~" + token;
    }

    /**
     * 一次token 保证一次请求 保证幂等请求问题
     *
     * @param request
     * @return
     */
    @RequestMapping("/addOrder")
    public String addOrder(HttpServletRequest request) {
        String token = request.getHeader("token");
        if (!redisToken.findToken(token)) {
            return "token 已经失效  重复提交";
        }
        return "完成业务逻辑";
    }

}
