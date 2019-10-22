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
	
	
	/**
	 * 测试链接：http://localhost:8080/brightstar/getxml/getName
	 * ResponseBody: 
	<XmlResponse>
		<name>key</name>
		<certnoList>
			<order>110105</order>
			<order>KSE231</order>
		</certnoList>
	</XmlResponse>
	 * */
	@RequestMapping(value = "/getName",produces = "application/xml")
	@ResponseBody
	public XmlResponse getName() {
		
		logger.info("---->brightstar/getxml/getName request:");
		XmlResponse ret = new XmlResponse("key");
		ret.addCert("110105");
		ret.addCert("KSE231");
		logger.info("<----brightstar/getxml/getRes response:{}",ret.toString());
		return ret;
	
	}
	

}
