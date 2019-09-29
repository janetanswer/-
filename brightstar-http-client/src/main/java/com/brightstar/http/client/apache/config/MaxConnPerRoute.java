package com.brightstar.http.client.apache.config;

public class MaxConnPerRoute {
	
	String ip;
	int port;
	int maxPerRoute;
	
	//每个Router的连接配置：IP^PORT^最大连接数
	//127.0.0.1^8080^10
	public MaxConnPerRoute(String str) {
		String[] stra = str.split("\\^");
		this.ip = stra[0];
		this.port = Integer.parseInt(stra[1]);
		this.maxPerRoute = Integer.parseInt(stra[2]);
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getMaxPerRoute() {
		return maxPerRoute;
	}

	public void setMaxPerRoute(int maxPerRoute) {
		this.maxPerRoute = maxPerRoute;
	}

}
