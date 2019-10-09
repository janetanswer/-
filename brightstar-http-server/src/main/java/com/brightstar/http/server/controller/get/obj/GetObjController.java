package com.brightstar.http.server.controller.get.obj;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brightstar/getObj")
public class GetObjController {
	
	Logger logger = LoggerFactory.getLogger(GetObjController.class);
	
	/**
	 * 测试链接：http://localhost:8080/brightstar/getObj/getName/key
	 * ResponseBody: "key getName Success"
	 * */
	@RequestMapping("/getName/{name}")
	public String getName(@PathVariable String name) {
		return name+" getName Success";
	}
	
	/**
	 * 测试链接： http://localhost:8080/brightstar/getObj/getFullName?firstName=key&lastName=lee
	 * ResponseBody: "key.lee getFullName Success"
	 */
	@RequestMapping("/getFullName")
	public String getFullName(String firstName,String lastName) {
		return firstName+"."+lastName+" getFullName Success";
	}
	
	
	
	
	

}
