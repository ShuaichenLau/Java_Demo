package com.alice.controller;

import com.alibaba.fastjson.JSONObject;
import com.alice.poji.RequestMessage;
import com.alice.poji.ResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * https://juejin.im/post/5ac8cd5c6fb9a028dd4e7ba6
 * @author scliuk
 * 2019-10-26 16:26:13
 */
public class BroadcastCtl {
    private final static Logger logger = LoggerFactory.getLogger(BroadcastCtl.class);

    // 收到消息计数器
    private AtomicInteger count = new AtomicInteger(0);


    @MessageMapping("/receive")
    @SendTo("/topic/getResponse")
    public ResponseMessage broadcast(RequestMessage requestMessage) {
        logger.info("receive message = {}", JSONObject.toJSONString(requestMessage));

        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setResponseMessage("BroadcastCtl receive [" + count.incrementAndGet() + "] records");

        return responseMessage;
    }

    @RequestMapping(value="/broadcast/index")
    public String broadcastIndex(HttpServletRequest httpRequest){
        System.out.println(httpRequest.getRemoteHost());
        return "websocket/simple/ws-broadcast";
    }
}
