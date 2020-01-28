package com.itmayiedu.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itmayiedu.base.BaseApiService;
import com.itmayiedu.base.ResponseBase;

// http协议特殊字符处理
@RestController
public class IndexController extends BaseApiService {

	// 1. 什么是特殊字符处理（rpc远程通讯 实现加密 + ?） 正好和http特殊相同，导致会转成空格
	// 2. 注意事项
	@RequestMapping("/indexPage")
	public ResponseBase indexPage(String userName) {
		System.out.println("userName:" + userName);
		return setResultSuccessData(userName);
	}

}
