package com.brightstar.designpattern.observer.springevent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class DemoPublisher {

	Logger logger = LoggerFactory.getLogger(DemoPublisher.class);
	
	@Autowired
	private ApplicationContext applicationContext;

	public void publish(String msg) {
		logger.debug("===publish 发送消息 .{}",msg);
		applicationContext.publishEvent(new DemoEvent(this, msg));
	}

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

}
