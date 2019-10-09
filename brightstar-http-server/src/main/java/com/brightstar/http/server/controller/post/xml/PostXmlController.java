package com.brightstar.http.server.controller.post.xml;

import java.time.LocalDateTime;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/brightstar/postXml")
public class PostXmlController {
	
	Logger logger = LoggerFactory.getLogger(PostXmlController.class);
	
	
	/**
	 * produces ： 指定返回值类型，不但可以设置返回值类型，还可以设定返回值的字符编码；
	 * consumes： 指定处理请求的提交内容类型（Content-Type），例如： text/plain(文本);application/json(json报文);application/xml(xml报文)
	 * 
	 * Postman测试1：
	 * 链接：http://localhost:8080/brightstar/postXml/postPerson
	 * 参数：
<Person>
    <name>key</name>
    <age>8</age>
    <gender>true</gender>
</Person>
	 * 返回：
<Response>
    <errorMsg>年龄必须大于18</errorMsg>
    <orderinfo/>
</Response>
	 * 
	 * 
	 * 
	 */

	@RequestMapping(value = "/postPerson", method = RequestMethod.POST, consumes="application/xml",produces = {"application/xml;charset=UTF-8"})
	@ResponseBody
	public Response postPerson(@RequestBody @Valid Person person,BindingResult bindingResult){
		logger.info("---->brightstar/postObj/postID request:{}",person);
		
		Response response = new Response("success",new Order("1NS3S3",LocalDateTime.now(),"food"));
		if(bindingResult.hasErrors()) {
			response = new Response(bindingResult.getFieldError().getDefaultMessage(),null);
		}
		
		logger.info("<----brightstar/postObj/postID response:{}",response.toString());
		return response;
	}
		
	

}
