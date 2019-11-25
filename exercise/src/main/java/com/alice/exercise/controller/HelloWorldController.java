package com.alice.exercise.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.hutool.core.date.DateUtil;

@RestController
public class HelloWorldController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping("/")
	public String index() {
		logger.info("com.alice.controller.HelloWorldController.index()");
		return "HelloWorld ==>" + DateUtil.now().toString();
	}
}
