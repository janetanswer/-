package com.brightstar.http.server.validate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("/brightstar/validate")
public class ValidateController {
	Logger logger = LoggerFactory.getLogger(ValidateController.class);
	
	
	/**
	 * http://localhost:8080/brightstar/validate/test
	 * 
{"memid":"memid123","name":"KeyLee","email":"key@gmail.com","age":36,"person":true,"insertTime":"2019-10-10 15:35:53","flightNo":"CA101","certs":["ni123456","ni654321"],"memnos":[{"memno":"mem12345"}],"home":{"address":"紫玉山庄"}}
	 * 
	 *  
	 */
//	@PostMapping(value = "/test", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = MediaType.APPLICATION_JSON_VALUE)
	@PostMapping(value = "/test", consumes = { MediaType.APPLICATION_XML_VALUE }, produces = MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public Response<String> test(@RequestBody @Valid Bean4Validate bean,BindingResult bindingResult){
		logger.info("---->brightstar/validate/test request:{}",bean);
		
		String ret = "success";
		if(bindingResult.hasErrors()) {
			ret = bindingResult.getFieldError().getDefaultMessage();
		}
		logger.info("<----brightstar/validate/test response:{}",ret);
		return new Response<String>("Return",ret,LocalDateTime.now());
	}
	
	
	
	
}
