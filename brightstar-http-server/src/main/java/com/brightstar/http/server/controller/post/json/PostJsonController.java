package com.brightstar.http.server.controller.post.json;

import java.time.LocalDateTime;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/brightstar/postJson")
public class PostJsonController {
	
	Logger logger = LoggerFactory.getLogger(PostJsonController.class);
	
	
	/**
	 * produces ： 指定返回值类型，不但可以设置返回值类型，还可以设定返回值的字符编码；
	 * consumes： 指定处理请求的提交内容类型（Content-Type），例如： text/plain(文本);application/json(json报文);application/xml(xml报文)
	 * 
	 * Postman测试1：
	 * 链接：http://localhost:8080/brightstar/postJson/postPerson
	 * 参数：{"name": "key","age": 8,"gender": true}
	 * 返回：
{
    "errorMsg": "success",
    "orderinfo": {
        "orderId": "1NS3S3",
        "orderDateTime": "2019-10-09T16:56:20.733",
        "productNames": [
            "food"
        ]
    }
}
	 * 
	 * 
	 * Postman测试2：
	 * 链接：http://localhost:8080/brightstar/postJson/postPerson
	 * 参数：{"age": 8,"gender": true}
	 * 返回：
{
    "errorMsg": "姓名不能为空",
    "orderinfo": null
}
	 * 
	 * 
	 */

	@RequestMapping(value = "/postPerson", method = RequestMethod.POST, consumes="application/json",produces = {"application/json;charset=UTF-8"})
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
