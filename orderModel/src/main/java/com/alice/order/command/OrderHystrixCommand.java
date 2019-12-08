package com.alice.order.command;

import com.alibaba.fastjson.JSONObject;
import com.alice.order.service.MemberService;
import com.netflix.hystrix.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * orderIndex服务请求实现服务降级 熔断 隔离机制
 * @author liusc
 */
public class OrderHystrixCommand extends HystrixCommand<JSONObject> {

    private final static Logger logger = LoggerFactory.getLogger(OrderHystrixCommand.class);

    @Autowired
    private MemberService memberService;

    public OrderHystrixCommand(MemberService memberService) {
        super(setter());
        this.memberService = memberService;
    }

    private static Setter setter() {
        // 服务分组
        HystrixCommandGroupKey groupkey = HystrixCommandGroupKey.Factory.asKey("order");
        // 服务标识
        HystrixCommandKey commandKey = HystrixCommandKey.Factory.asKey("order");
        // 线程池名称 每个服务都有自己的线程池
        HystrixThreadPoolKey hystrixThreadPoolKey = HystrixThreadPoolKey.Factory.asKey("order-pool");
        // 线程池配置 线程池大小10 线程存活时间为15秒 队列等待的阈值为100 超过100执行拒绝策略 配置服务熔断
        HystrixThreadPoolProperties.Setter threadPoolProperties = HystrixThreadPoolProperties.Setter()
                .withCoreSize(10)
                .withKeepAliveTimeMinutes(15)
                .withQueueSizeRejectionThreshold(100);

        // 命令属性配置Hystrix 开启超时
        HystrixCommandProperties.Setter commandProperties = HystrixCommandProperties.Setter()
                // 采用线程池方式实现服务隔离
                .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD)
                // 禁止超时
                .withExecutionTimeoutEnabled(false);

        return HystrixCommand.Setter.withGroupKey(groupkey)
                .andCommandKey(commandKey)
                .andThreadPoolKey(hystrixThreadPoolKey)
                .andThreadPoolPropertiesDefaults(threadPoolProperties)
                .andCommandPropertiesDefaults(commandProperties);
    }

    /**
     * run 表示服务执行的代码
     * @return
     * @throws Exception
     */
    @Override
    protected JSONObject run() throws Exception {

        JSONObject member = memberService.getMember();

        logger.info("当前线程名称:{},member:{}",Thread.currentThread().getName(),member);

        return member;
    }

    /**
     * 服务降级
     * @return
     */
    @Override
    protected JSONObject getFallback() {

        // 如果Hystrix发生熔断 当服务不可用 直接执行fallback方法
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code","500");
        jsonObject.put("message","系统错误! 服务降级");
        return jsonObject;
    }


}
