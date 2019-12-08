package com.alice.order.service;

import com.alibaba.fastjson.JSONObject;
import com.alice.order.utils.HttpClientUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public JSONObject getMember(){
        JSONObject result = HttpClientUtils.httpGet("http://127.0.0.1:8081/member/memberIndex");
        return result;
    }

}
