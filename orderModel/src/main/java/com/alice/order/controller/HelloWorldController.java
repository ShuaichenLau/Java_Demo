package com.alice.order.controller;

import com.alice.order.utils.TokenUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {


    @RequestMapping("/token")
    public String getToken() {
        return TokenUtils.getToken();
    }

    @RequestMapping(value = "/addOrder", produces = "application/json;charset=utf-8")
    public String addOrder(HttpServletRequest request) {
        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)) {
            return "参数错误";
        }

        if (!TokenUtils.findToken(token)) {
            return "请勿重复提交!";
        }

        return Calendar.getInstance().getTime().toString();

    }

}
