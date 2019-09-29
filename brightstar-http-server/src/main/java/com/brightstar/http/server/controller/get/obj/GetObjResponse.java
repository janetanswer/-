package com.brightstar.http.server.controller.get.obj;

public class GetObjResponse {
	
	String errorMsg;
	
	OrderInfo orderinfo;

	public GetObjResponse(String errorMsg, OrderInfo orderinfo) {
		super();
		this.errorMsg = errorMsg;
		this.orderinfo = orderinfo;
	}
	
	

}
