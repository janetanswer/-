package com.brightstar.http.server.controller.get.obj;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderInfo {
	


	String orderId;
	
	LocalDateTime orderDateTime;
	
	List<String> productNames;
	
	
	public OrderInfo(String orderId, LocalDateTime orderDateTime, String productName) {
		super();
		this.orderId = orderId;
		this.orderDateTime = orderDateTime;
		this.productNames = new ArrayList<String>();
		productNames.add(productName);
		
	}


	@Override
	public String toString() {
		return "OrderInfo [orderId=" + orderId + ", orderDateTime=" + orderDateTime + ", productNames=" + productNames
				+ "]";
	}

}
