package com.alice.order.command;

import com.alibaba.fastjson.JSONObject;
import com.alice.order.service.MemberService;
import com.netflix.hystrix.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderHystrixCommand2 extends HystrixCommand<JSONObject> {

    private final static Logger logger = LoggerFactory.getLogger(OrderHystrixCommand2.class);

    @Autowired
    private MemberService memberService;

    public OrderHystrixCommand2(MemberService memberService) {
        super(setter());
        this.memberService = memberService;
    }

    private static Setter setter() {
        // 服务分组
        HystrixCommandGroupKey groupkey = HystrixCommandGroupKey.Factory.asKey("order");
        // 命令属性配置 采用信号量模式
        HystrixCommandProperties.Setter commandProperties = HystrixCommandProperties.Setter()
                .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.SEMAPHORE)
                // 使用原子计数器(或者信号量)来记录当前有多少线程在运行,当请求进来时先判断计数器的值,
                // 若超过设置的最大线程个数则拒绝该请求,若不超过则通行,这时候计数器+1,请求返回成功后计数器-1
                .withExecutionIsolationSemaphoreMaxConcurrentRequests(50);

        return HystrixCommand.Setter.withGroupKey(groupkey).andCommandPropertiesDefaults(commandProperties);

    }

    @Override
    protected JSONObject run() throws Exception {

        JSONObject member = memberService.getMember();

        logger.info("当前线程名称:{},member:{}",Thread.currentThread().getName(),member);

        return member;
    }

    @Override
    protected JSONObject getFallback() {

        // 如果Hystrix发生熔断 当服务不可用 直接执行fallback方法
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",500);
        jsonObject.put("message","系统错误!");
        return jsonObject;
    }


}
