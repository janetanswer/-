package com.brightstar.http.server.controller.get.xml;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brightstar/getxml")
public class GetXmlController {
	
	Logger logger = LoggerFactory.getLogger(GetXmlController.class);
	
	

	@RequestMapping("/getRes")
	public @ResponseBody XmlResponse getJson_getRes() {
		
		logger.info("---->brightstar/getxml/getRes request:");
		XmlResponse ret = new XmlResponse("key");
		logger.info("<----brightstar/getxml/getRes response:{}",ret.toString());
		return ret;
	
	}
	
	

//	@RequestMapping("/getOrderInfo")
//	JsonResponse getJson_getOrderInfo(JsonRequest person) {
//		
//		logger.info("---->brightstar/getjson/getOrderInfo\n request:{}",person.toString());
//		JsonResponse ret = new JsonResponse(person.getName(),LocalDateTime.now(),"food");
//		logger.info("<----brightstar/getjson/getOrderInfo\n response:{}",ret.toString());
//		return ret;
//	
//	}
	

	
	

}
