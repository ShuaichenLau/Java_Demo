package com.alice.api;

import com.alice.annotation.ExtRateLimiter;
import com.alice.service.OrderService;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.RateLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
public class IndexApiController {

    private final Logger logger = LoggerFactory.getLogger(IndexApiController.class);

    @Autowired
    private OrderService orderService;

    // create 方法传入一个参数 以每秒为单位固定的速率值1r/s 每秒往桶中放入一个令牌
    RateLimiter rateLimiter = RateLimiter.create(1);

    @RequestMapping("/addOrder")
    public Map addOrder() {

        // 1.限流处理 限流正常要放在网关 客户端从桶中获取对应的令牌 为什么返回double结果
        // 结果表示 从桶中拿到令牌等待时间

        // 2.如果获取不到令牌 就会一直等待. 设置服务降级处理 (相当于配置在规定时间内如果没有获取到令牌的话,直接走服务降级)
        HashMap<String, Object> result = Maps.newHashMap();

        double acquire = rateLimiter.acquire();
        System.out.println("从桶中获取令牌等待的时间是 == > " + acquire);

        boolean b1 = rateLimiter.tryAcquire(500, TimeUnit.MILLISECONDS);

        if (!b1) {
            result.put("msg", "请稍后再来试试!!!");
            result.put("acquire", acquire);
            return result;
        }

        boolean b = orderService.addOrder();

        if (b) {
            System.out.println("恭喜你 抢购成功!!!");

            result.put("msg", "恭喜你 抢购成功!!!");
            result.put("acquire", acquire);
            return result;
        }
        return result;
    }


    /**
     * 以每秒添加1个令牌到令牌桶中
     * @return
     */
    @RequestMapping("/selectOrder")
    @ExtRateLimiter(permitsPerSecond = 1.0, timeout = 100)
    public Map selectOrder() {
        HashMap<String, Object> result = Maps.newHashMap();

        result.put("time", Calendar.getInstance().getTime().toString());
        result.put("uuid", UUID.randomUUID().toString());

        return result;
    }

}
