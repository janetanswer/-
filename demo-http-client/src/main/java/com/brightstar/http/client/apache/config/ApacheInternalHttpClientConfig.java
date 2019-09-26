package com.brightstar.http.client.apache.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties
@PropertySource("classpath:httpClient.properties")
@Data
public class ApacheInternalHttpClientConfig {
	// 最大连接数
	int MaxTotal = 20;

	// 每个Router默认的最大连接数
	int MaxPerRoute = 20;
	
	//每个Router的连接配置：IP^PORT^最大连接数。多个以;分隔
	//127.0.0.1^8080^10;182.11.23.12^8080^10
	List<String> MaxPerSomeRoutes = new ArrayList<String>();
	
	/*****************KeepAlive*********/
	// true:会考虑服务端返回的报文头部是否有“Keep-Alive”字段来告诉客户端应该保持多长时间链接
	// false:不考虑
	boolean KeepAlivePrior=false;
	
	// 设定特殊host的keepAlive时间
	Map<String, Integer> KeepAliveRoutes = null;
	
	
	// 默认的Idle的连接最长保持时间：30s
	// connectionManager.closeIdleConnections(maxIdleTimeMs, TimeUnit.MILLISECONDS);
	long DefaultKeepAliveSeconds = 30;
	
	
	
	/**************proxy****************/
	// 代理IP
	String ProxyIp="";
	
	// 代理Port
	int ProxyPort=0;
	
	public boolean validProxy() {
		if(ProxyIp!=null && ProxyPort!=0 && ProxyIp.length()>7) {
			return true;
		}
		return false;
	}
	/***************Request timeout ***************/
	/*从连接池获取连接的超时时间*/
	
	private int connectionRequestTimeout=10*1000;

	/*建立连接的超时
	 * httpclient创建一个异步线程用以创建socket连接，此处设置该socket的连接超时时间
	 * */
	private int connectTimeout=10*1000;
	
	/*等待反馈的超时时间*/
	private int socketTimeout=10*1000;
	
	
	/***************Request timeout ***************/
	/*最多重试次数,默认不重试*/
	int maxRetryTimes=0;
	
	/****************访问权限认证********************/
	List<AuthPerRoute> authConfig = new ArrayList<AuthPerRoute>();
	
	
	
	

	
	public int getMaxTotal() {
		return MaxTotal;
	}

	public void setMaxTotal(int maxTotal) {
		MaxTotal = maxTotal;
	}

	public int getMaxPerRoute() {
		return MaxPerRoute;
	}

	public void setMaxPerRoute(int maxPerRoute) {
		MaxPerRoute = maxPerRoute;
	}
	
	public List<String> getMaxPerSomeRoutes() {
		return MaxPerSomeRoutes;
	}
	
	public void setMaxPerSomeRoutes(List<String> maxPerSomeRoutes) {
		MaxPerSomeRoutes = maxPerSomeRoutes;
	}



	public String getProxyIp() {
		return ProxyIp;
	}

	public void setProxyIp(String proxyIp) {
		ProxyIp = proxyIp;
	}

	public int getProxyPort() {
		return ProxyPort;
	}

	public void setProxyPort(int proxyPort) {
		ProxyPort = proxyPort;
	}




	public boolean isKeepAlivePrior() {
		return KeepAlivePrior;
	}

	public void setKeepAlivePrior(boolean keepAlivePrior) {
		KeepAlivePrior = keepAlivePrior;
	}

	public Map<String, Integer> getKeepAliveRoutes() {
		return KeepAliveRoutes;
	}

	public void setKeepAliveRoutes(Map<String, Integer> keepAliveRoutes) {
		KeepAliveRoutes = keepAliveRoutes;
	}

	public long getDefaultKeepAliveSeconds() {
		return DefaultKeepAliveSeconds;
	}

	public void setDefaultKeepAliveSeconds(long defaultKeepAliveSeconds) {
		DefaultKeepAliveSeconds = defaultKeepAliveSeconds;
	}

	public int getConnectionRequestTimeout() {
		return connectionRequestTimeout;
	}

	public void setConnectionRequestTimeout(int connectionRequestTimeout) {
		this.connectionRequestTimeout = connectionRequestTimeout;
	}

	public int getConnectTimeout() {
		return connectTimeout;
	}

	public void setConnectTimeout(int connectTimeout) {
		this.connectTimeout = connectTimeout;
	}

	public int getSocketTimeout() {
		return socketTimeout;
	}

	public void setSocketTimeout(int socketTimeout) {
		this.socketTimeout = socketTimeout;
	}

	public int getMaxRetryTimes() {
		return maxRetryTimes;
	}

	public void setMaxRetryTimes(int maxRetryTimes) {
		this.maxRetryTimes = maxRetryTimes;
	}

	public List<AuthPerRoute> getAuthConfig() {
		return authConfig;
	}

	public void setAuthConfig(List<AuthPerRoute> authConfig) {
		this.authConfig = authConfig;
	}





	

	
	
	
	
	



}
