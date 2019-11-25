package com.alice.exercise.controller;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alice.exercise.entity.Person;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.json.JSONObject;

@RestController
public class HelloWorldController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping("/")
	public String index() {
		logger.info("com.alice.controller.HelloWorldController.index()");
		return "HelloWorld ==>" + DateUtil.now().toString();
	}
	
	@RequestMapping("/getPerson")
	public String getPerson(){
		Person person = Person.getPerson();
		person.setId(new Random().nextInt(10));
		person.setName(UUID.randomUUID().toString());
		person.setAddress(UUID.randomUUID().toString().replaceAll("-", ""));
		person.setAge(new Random().nextInt(100));
		return person.toString();
	}
}
