package com.alice.order.controller;

import com.alibaba.fastjson.JSONObject;
import com.alice.order.command.OrderHystrixCommand;
import com.alice.order.command.OrderHystrixCommand2;
import com.alice.order.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MemberService memberService;

    @RequestMapping("/orderIndex")
    public Object orderIndex(){
        JSONObject member = memberService.getMember();
        logger.info("当前线程名称:{},订单调用会员服务member:{}",Thread.currentThread().getName(),member);
        return member;
    }

    /**
     * 订单服务调用会员服务 解决服务雪崩效应 底层使用服务隔离 线程池方式实现
     * @return
     */
    @RequestMapping("/orderIndexHystrix")
    public Object orderIndexHystrix(){
        JSONObject result = new OrderHystrixCommand(memberService).execute();
        return result;
    }

    @RequestMapping("/orderIndexHystrix2")
    public Object orderIndexHystrix2(){
        return new OrderHystrixCommand2(memberService).execute();
    }

    @RequestMapping("/findOrderIndex")
    public Object findOrderIndex(){
        logger.info("当前线程:" + Thread.currentThread().getName() + ",findOrderIndex");
        return "findOrderIndex";
    }

}
