package com.brightstar.designpattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.brightstar.designpattern.observer.springevent.DemoPublisher;

@Component
public class CallBean {
	
	@Autowired
	DemoPublisher demoPublisher;
	
	
	public void invoke() {
		demoPublisher.publish("zhangsan");
	}
	
	
	

}
