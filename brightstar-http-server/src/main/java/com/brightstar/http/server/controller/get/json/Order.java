package com.brightstar.http.server.controller.get.json;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
	
	String orderId;

	LocalDateTime orderDateTime;
	
	List<String> productNames;
	
	public Order() {}
	
	public Order(String orderId, LocalDateTime orderDateTime, String productName) {
		super();
		this.orderId = orderId;
		this.orderDateTime = orderDateTime;
		this.productNames = new ArrayList<String>();
		productNames.add(productName);
		
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public LocalDateTime getOrderDateTime() {
		return orderDateTime;
	}

	public void setOrderDateTime(LocalDateTime orderDateTime) {
		this.orderDateTime = orderDateTime;
	}

	public List<String> getProductNames() {
		return productNames;
	}

	public void setProductNames(List<String> productNames) {
		this.productNames = productNames;
	}

	@Override
	public String toString() {
		return "JsonResponse [orderId=" + orderId + ", orderDateTime=" + orderDateTime + ", productNames="
				+ productNames + "]";
	}
	





}
