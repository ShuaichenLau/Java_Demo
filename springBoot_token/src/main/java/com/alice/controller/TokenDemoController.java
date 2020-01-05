package com.alice.controller;

import com.alice.base.BaseApiService;
import com.alice.base.ResponseBase;
import com.alice.entity.AppEntity;
import com.alice.mapper.AppMapper;
import com.alice.utils.BaseRedisService;
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
public class TokenDemoController extends BaseApiService {

    @Autowired
    private RedisToken redisToken;

    @Autowired
    private AppMapper appMapper;

    @Autowired
    private BaseRedisService baseRedisService;

    private final static Long timeOut = 60 * 60 * 2l;

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

    @RequestMapping("/getAccessToken")
    public ResponseBase getAccessToken(AppEntity appEntity) {

        //1.获取生成对应appId和appSecret验证是否可用

        //2.使用Appid+appSecret保证唯一生成对应的getAccessToken
        //3.删除之前AccessToken
        //4.返回最新的AccessToken
        // 第二步骤 第三步骤 要在同一个事务
        return null;
    }

}
