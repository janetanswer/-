package com.brightstar.http.client.apache.interceptor;

import java.util.ArrayList;

public class InterceptorConfig {
	
	
	public ArrayList<String> requestInterceptorNames;
	
	public ArrayList<String> responseInterceptorNames;

	public ArrayList<String> getRequestInterceptorNames() {
		return requestInterceptorNames;
	}

	public void setRequestInterceptorNames(ArrayList<String> requestInterceptorNames) {
		this.requestInterceptorNames = requestInterceptorNames;
	}

	public ArrayList<String> getResponseInterceptorNames() {
		return responseInterceptorNames;
	}

	public void setResponseInterceptorNames(ArrayList<String> responseInterceptorNames) {
		this.responseInterceptorNames = responseInterceptorNames;
	}

}
