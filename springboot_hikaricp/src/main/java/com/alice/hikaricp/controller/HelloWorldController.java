package com.alice.hikaricp.controller;

import com.alice.hikaricp.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.sql.DataSource;

@RestController
@RequestMapping("/")
public class HelloWorldController {

    private final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

    @Resource
    private DataSource dataSource;

    @Autowired
    private IUserService userService;

    @RequestMapping("/")
    public String index() {

        logger.info("com.alice.hikaricp.controller.HelloWorldController.index");

        logger.info("dataSource ==>" + dataSource.getClass());

        logger.info("userService ==>" + userService.getClass());

        return "Greetings from Spring Boot! ";
    }
}
