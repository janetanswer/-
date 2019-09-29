package com.brightstar.http.server.controller.get.obj;

import java.time.LocalDateTime;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brightstar/getObj")
public class GetObjController {
	
	Logger logger = LoggerFactory.getLogger(GetObjController.class);
	
	/**
	 * 测试链接：http://localhost:8080/brightstar/getObj/getName/key
	 * 请求responseBody: "key getName Success"
	 * */
	@RequestMapping("/getName/{name}")
	public String getObj_getName(@PathVariable String name) {
		return name+" getName Success";
	}
	
	/**
	 * 测试链接： http://localhost:8080/brightstar/getObj/getName2?firstName=key&lastName=lee
	 * 请求responseBody: "key.lee getName2 Success"
	 */
	@RequestMapping("/getName2")
	public String getObj_getName2(String firstName,String lastName) {
		return firstName+"."+lastName+" getName2 Success";
	}
	
	
	/**
	 * 根据旅客信息查询订单信息
	 * 测试链接：http://localhost:8080/brightstar/getobj
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getOrderObj", method = RequestMethod.GET)
	public GetObjResponse getObj_getOrder(@Valid GetObjRequest request,BindingResult bindingResult) {
		
		logger.info("brightstar/getobj Request:\n{}",request.toString());
		
		GetObjResponse response = new GetObjResponse("success",new OrderInfo("1NS3S3",LocalDateTime.now(),"food"));
		
		if(bindingResult.hasErrors()) {
			response = new GetObjResponse(bindingResult.getFieldError().getDefaultMessage(),null);
		}
		
		logger.info("brightstar/getobj Request:\n{}",response.toString());
		
		return response;
	}

}
