package com.brightstar.designpattern.observer.springevent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class DemoListener implements ApplicationListener<DemoEvent>{

	Logger logger = LoggerFactory.getLogger(DemoListener.class);
	@Override
	public void onApplicationEvent(DemoEvent event) {
		 String msg = event.getMsg();
		 logger.debug("===demoListener接受到了demoPublisher发布的消息：{}",msg);
	}

}
