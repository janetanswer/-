package com.brightstar.http.server.controller.post.json;

public class Response {
	
	String errorMsg;
	
	Order orderinfo;

	public Response(String errorMsg, Order orderinfo) {
		super();
		this.errorMsg = errorMsg;
		this.orderinfo = orderinfo;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public Order getOrderinfo() {
		return orderinfo;
	}

	public void setOrderinfo(Order orderinfo) {
		this.orderinfo = orderinfo;
	}

	@Override
	public String toString() {
		return "Response [errorMsg=" + errorMsg + ", orderinfo=" + orderinfo + "]";
	}
	
	

}
