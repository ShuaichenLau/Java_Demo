package com.alice.api;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.alice.service.OrderService;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.RateLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class IndexApiController {

    @Autowired
    private OrderService orderService;

    // create 方法传入一个参数 以每秒为单位固定的速率值1r/s 每秒往桶中放入一个令牌
    RateLimiter rateLimiter = RateLimiter.create(1);

    @RequestMapping("/addOrder")
    public Map addOrder() {

        // 1.限流处理 限流正常要放在网关 客户端从桶中获取对应的令牌 为什么返回double结果
        // 结果表示 从桶中拿到令牌等待时间

        // 2.如果获取不到令牌 就会一直等待
        HashMap<String, Object> result = Maps.newHashMap();

        double acquire = rateLimiter.acquire();
        System.out.println("从桶中获取令牌等待的时间是 == > " + acquire);

        boolean b = orderService.addOrder();

        if (b) {
            System.out.println("恭喜你 抢购成功!!!");

            result.put("msg","恭喜你 抢购成功!!!");
            result.put("acquire",acquire);
            return result;
        }
        return result;
    }

}
