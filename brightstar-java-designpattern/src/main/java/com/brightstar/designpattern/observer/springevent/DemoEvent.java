package com.brightstar.designpattern.observer.springevent;

import org.springframework.context.ApplicationEvent;

public class DemoEvent extends ApplicationEvent{

	/*serialVersionUID: TODO*/ 
	private static final long serialVersionUID = 1L;
	
	
	private String msg;
	
	
	public DemoEvent(Object source,String msg) {
		super(source);
		this.msg = msg;
		// TODO Auto-generated constructor stub
	}


	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
