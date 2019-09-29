package com.brightstar.http.server.controller.get.json;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brightstar/getjson")
public class GetJsonController {
	
	Logger logger = LoggerFactory.getLogger(GetJsonController.class);
	
	
	
	/**
	 * 测试链接：http://localhost:8080/brightstar/getjson/getJsonPerson
	 * 请求responseBody: "{"name":"key","age":8,"gender":true}"
	 * 
	 * 测试类：
	 * com.brightstar.http.client.controller.get.json.test_getJson_getOrderInfo_1
	 * com.brightstar.http.client.controller.get.json.test_getJson_getOrderInfo_2
	 * com.brightstar.http.client.controller.get.json.test_getJson_getOrderInfo_3
	 * 
	 * 返回对象会自动解析为json串，但要注意两点：
	 * 1. 添加jackson-core、jackson-databind依赖
	 * 2. 对象上要有set、get方法
	 */
	@RequestMapping("/getJsonPerson")
	JsonRequest getJson_getJsonPerson() {
		
		logger.info("---->brightstar/getjson/getJsonPerson request:");
		JsonRequest ret = new JsonRequest("key",8,true);
		logger.info("<----brightstar/getjson/getJsonPerson response:{}",ret.toString());
		return ret;
	
	}
	
	
	
	/**
	 * 测试链接：http://localhost:8080/brightstar/getjson/getOrderInfo?name=key&age=8&gender=true
	 * 请求responseBody: "{"orderId":"key","orderDateTime":"2019-09-29T10:28:39.529","productNames":["food"]}"
	 * 
	 */
	@RequestMapping("/getOrderInfo")
	JsonResponse getJson_getOrderInfo(JsonRequest person) {
		
		logger.info("---->brightstar/getjson/getOrderInfo\n request:{}",person.toString());
		JsonResponse ret = new JsonResponse("id57697",LocalDateTime.now(),"food");
		logger.info("<----brightstar/getjson/getOrderInfo\n response:{}",ret.toString());
		return ret;
	
	}
	

	
	

}
