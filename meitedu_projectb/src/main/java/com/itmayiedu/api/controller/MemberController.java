package com.itmayiedu.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itmayiedu.base.BaseApiService;
import com.itmayiedu.base.ResponseBase;

@RestController
@RequestMapping("/openApi")
public class MemberController extends BaseApiService {

	@RequestMapping("/getUser")
	public ResponseBase getUser() {
		return setResultSuccess("获取会员信息接口");
	}
}
