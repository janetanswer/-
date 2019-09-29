package com.brightstar.http.server.controller.get.json;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.ToString;


@Data 
@ToString
public class JsonResponse {
	
	String orderId;

	LocalDateTime orderDateTime;
	
	List<String> productNames;
	
	public JsonResponse() {}
	
	public JsonResponse(String orderId, LocalDateTime orderDateTime, String productName) {
		super();
		this.orderId = orderId;
		this.orderDateTime = orderDateTime;
		this.productNames = new ArrayList<String>();
		productNames.add(productName);
		
	}
	





}
