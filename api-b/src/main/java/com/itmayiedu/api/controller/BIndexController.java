package com.itmayiedu.api.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class BIndexController {
	@RequestMapping("/")
	public String index() {
		return "我是B项目....";
	}

	public static void main(String[] args) {
		SpringApplication.run(BIndexController.class, args);
	}
}
