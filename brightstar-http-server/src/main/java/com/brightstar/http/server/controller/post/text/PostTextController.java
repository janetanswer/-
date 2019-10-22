package com.brightstar.http.server.controller.post.text;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brightstar/postText")
public class PostTextController {
	
	Logger logger = LoggerFactory.getLogger(PostTextController.class);

	
	/**
	 * Postman测试
	 * 链接：http://localhost:8080/brightstar/postText/postID
	 * 参数：Body-raw-Text：123
	 * 
	 * 返回：true/false
	 */
	@ResponseBody
	@PostMapping("/postID")
	public Boolean postID(@RequestBody String id){
		logger.info("---->brightstar/postText/postID request:{}",id);
		logger.info("<----brightstar/postText/postID response:{}",true);
		return false;
	}
	
	

	


}
