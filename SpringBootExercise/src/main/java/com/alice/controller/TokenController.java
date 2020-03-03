package com.alice.controller;

import com.alice.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenController {
	@Autowired
	private TokenService tokenService;
	@Value("${server.port}")
	private String serverPort;

	@RequestMapping("/put")
	public String put(String nameValue) {
		String token = tokenService.put(nameValue);
		return token + "-" + serverPort;
	}

	@RequestMapping("/get")
	public String get(String token) {
		String value = tokenService.get(token);
		return value + "-" + serverPort;
	}

}
