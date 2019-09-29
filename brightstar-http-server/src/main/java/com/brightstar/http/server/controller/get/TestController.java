package com.brightstar.http.server.controller.get;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brightstar")
public class TestController {
	
	Logger logger = LoggerFactory.getLogger(TestController.class);
	
	/**
	 * 测试链接：http://localhost:8080/brightstar/getSuccess
	 * 返回Test Success
	 * */
	@RequestMapping(value = "/getSuccess",method = RequestMethod.GET)
	public String test() {
		logger.info("Test Success");
		return "Test Success";
	}

}
