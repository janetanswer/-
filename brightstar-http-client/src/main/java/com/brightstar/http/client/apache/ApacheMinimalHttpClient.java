package com.brightstar.http.client.apache;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 *	ApacheMinimalHttpClient
 *
 *	private final HttpClientConnectionManager connManager:
 *	连接池组件，管理连接的整个生命周期。连接在连接池中创建、复用以及移除。
 *	Connection manager封装了对连接池的具体操作，比如向连接池租用和归还连接。
 *	Connection被创建出来后处于闲置状态，由连接池管理，调用时会校验是否是open状态，不是的话会进行connect。
 *	connect的过程就是 基于不同schema(主要是http和https)创建不同的socket连接(ssl和plain)并且将http请求（连接）绑定到socket。
 *	同时连接也会因为心跳或者过期等原因被close变成stale状态，直至被下一次get到时或者连接满时被清理出去。
 *	同时连接池还能对连接进行限流–全局和单route连接数。
 *
 *  private final MinimalClientExec requestExecutor:
 *  代表一次完整的调用执行过程.
 *  是ClientExecChain的一个实现，只是封装了最基本的HTTP过程，提供最直接的客户端服务器交互.
 *  不支持代理，不支持在各种情况下的重试（重定向，权限校验，IO异常等）。
 *
 */
@Component
public class ApacheMinimalHttpClient {
	
	Logger logger = LoggerFactory.getLogger(ApacheMinimalHttpClient.class);

	CloseableHttpClient httpClient;
	
	
	public ApacheMinimalHttpClient() {
		this.httpClient = HttpClients.createMinimal();
	}


	public CloseableHttpClient getHttpClient() {
		return httpClient;
	}

}
