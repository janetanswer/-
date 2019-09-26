package com.brightstar.http.client.apache;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApacheDefaultHttpClient {
	
	Logger logger = LoggerFactory.getLogger(ApacheDefaultHttpClient.class);

	CloseableHttpClient httpClient;
	
	
	public ApacheDefaultHttpClient() {
		this.httpClient = HttpClients.createDefault();
	}
	

}
