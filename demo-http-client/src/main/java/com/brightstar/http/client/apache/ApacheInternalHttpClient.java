package com.brightstar.http.client.apache;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HeaderElementIterator;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.MessageConstraints;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.DnsResolver;
import org.apache.http.conn.HttpConnectionFactory;
import org.apache.http.conn.ManagedHttpClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.DefaultHttpResponseFactory;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.DefaultHttpResponseParser;
import org.apache.http.impl.conn.DefaultHttpResponseParserFactory;
import org.apache.http.impl.conn.ManagedHttpClientConnectionFactory;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.impl.conn.SystemDefaultDnsResolver;
import org.apache.http.impl.io.DefaultHttpRequestWriterFactory;
import org.apache.http.io.HttpMessageParser;
import org.apache.http.io.HttpMessageParserFactory;
import org.apache.http.io.HttpMessageWriterFactory;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.message.BasicLineParser;
import org.apache.http.message.LineParser;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.CharArrayBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.brightstar.http.client.apache.config.ApacheInternalHttpClientConfig;
import com.brightstar.http.client.apache.config.MaxConnPerRoute;
import com.brightstar.http.client.apache.interceptor.InterceptorConfig;
import com.brightstar.http.client.apache.interceptor.RequestInterceptor;
import com.brightstar.http.client.apache.interceptor.ResponseInterceptor;

@Component
public class ApacheInternalHttpClient {

	Logger logger = LoggerFactory.getLogger(ApacheInternalHttpClient.class);

	CloseableHttpClient httpClient;

	@Autowired
	ApacheInternalHttpClientConfig config;
	
//	@Autowired
//	InterceptorConfig interceptorConfig;
//	@Autowired
//	RequestInterceptor reqestInterceptor;
//	@Autowired
//	ResponseInterceptor responseInterceptor;

	
	/**
	 * CloseableHttpClient配置： 
	 * 1. 配置连接管理：自定义了一个PoolingHttpClientConnectionManager对象，用于管理连接
	 * 
	 * 2.KeepAlive策略
	 * 一个典型阻塞 I/O 的模型的主要缺点是网络socket仅当 I/O 操作阻塞时才可以响应 I/O事件。
	 * 当一个连接被释放回管理器时，它可以被保持活动状态而却不能监控socket的状态和响应任何 I/O 事件。
	 * 使用专用的监控线程 来收回被Server端中止的连接 和 因为长时间不活动而被认为是过期的连接 。
	 * 
	 * 3.代理
	 * 通过代理进行访问
	 * 
	 * 4.请求的一系列默认超时时间
	 * 
	 * 5.重试机制
	 * 
	 * 6.访问权限认证,目前只支持Basic认证,出于安全考虑，建议换成Digest认证
	 * Basic:用户名+密码，因为是明文存储，所以建议和TLS/SSL的加密配合使用。
	 * Digest: MD5 哈希处理密码，可以防止重放攻击
	 * 
	 * 
	 * HttpRequest和HttpResponse的处理拦截器
	 * 
	 */
	@PostConstruct
	public void initHttpClient() {
		
		logger.info("初始化HttpClient开始...");
		
		HttpClientBuilder httpClientBuilder = HttpClients.custom();
		
		//1.连接数量管理
		httpClientBuilder.setConnectionManager(myConnManager(config.getMaxTotal(),config.getMaxPerRoute(),config.getMaxPerSomeRoutes()));		
		

		//2.调 用ClientConnectionManager#closeExpiredConnections()方法来关闭所有过期 的 连 接 并且从 连 接 池 中 收 回 关 闭 的 连 接 。
		httpClientBuilder.evictExpiredConnections();
		
		//2.调 用ClientConnectionManager#closeIdleConnections()方法来关闭所有已经空闲超过给定时间周期的连接。
		//if{所有的Client都使用统一的keepAlive时间}
		//else{优先考虑server端建议的保持连接时间；其次为特定的server设置保持连接时间；剩下的使用统一的保持连接时间}		
		if(config.isKeepAlivePrior() && config.getKeepAliveRoutes()==null) {
			httpClientBuilder.evictIdleConnections(config.getDefaultKeepAliveSeconds(), TimeUnit.SECONDS);
		}else {
			httpClientBuilder.setKeepAliveStrategy(myConnKAliveStrategy(config.getKeepAliveRoutes(),config.getDefaultKeepAliveSeconds()));
		}

		//3.代理
		if(config.validProxy()) {
			httpClientBuilder.setProxy(new HttpHost(config.getProxyIp(), config.getProxyPort(), null));
		}
		
		//4.超时时间
		httpClientBuilder.setDefaultRequestConfig(myRequestConfig(config.getConnectionRequestTimeout(),config.getConnectTimeout(),config.getSocketTimeout()));

		//5.重试机制
		httpClientBuilder.setRetryHandler(myRetryHandler(config.getMaxRetryTimes()));
	
		//6.访问权限认证
		CredentialsProvider credsProvider = new BasicCredentialsProvider();
		config.getAuthConfig().forEach(authc->{
	        credsProvider.setCredentials(
	                new AuthScope(authc.getHost(), authc.getPort(),authc.getRealm(),authc.getScheme()),
	                new UsernamePasswordCredentials(authc.getUserName(), authc.getPassword()));
		});
		httpClientBuilder.setDefaultCredentialsProvider(credsProvider);
				
		
//		//请求和反馈拦截器
//		if(interceptorConfig!=null) {
//			interceptorConfig.getRequestInterceptorNames().forEach(reqi->{
//				if(reqestInterceptor.getMap().containsKey(reqi)) {
//					httpClientBuilder.addInterceptorFirst(reqestInterceptor.getMap().get(reqi));
//				}
//			});
//			
//			interceptorConfig.getResponseInterceptorNames().forEach(resi->{
//				if(responseInterceptor.getMap().containsKey(resi)) {
//					httpClientBuilder.addInterceptorFirst(responseInterceptor.getMap().get(resi));
//				}
//			});
//			
//		}
		
		httpClient = httpClientBuilder.build();
		logger.info("初始化HttpClient成功...");
	}
	

	
	
	
	/**
	 * 配置ConnectionManager.自定义了一个PoolingHttpClientConnectionManager对象
	 * 配置项包含: 
	 * 1.最大连接数 
	 * 2.每个Route的最大连接数
	 * 3.特定Route的最大连接数:127.0.0.1^8080^10
	 */
	private PoolingHttpClientConnectionManager myConnManager(int MaxTotal,int MaxPerRoute,List<String> MaxPerSomeRoutes) {
		PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
		cm.setMaxTotal(MaxTotal);
		cm.setDefaultMaxPerRoute(MaxPerRoute);
		for(String str:MaxPerSomeRoutes) {
			MaxConnPerRoute mpsr = new MaxConnPerRoute(str);
			HttpHost host = new HttpHost(mpsr.getIp(), mpsr.getPort());
			cm.setMaxPerRoute(new HttpRoute(host), mpsr.getMaxPerRoute());
		}

		return cm;
	}
	

	/**
	 * HTTP1.1是支持长连接的。但规范中没有详细说明一个持久连接可能或应该保持活动多长时间。
	 * 正常情况下，请求中会带上Connnection:keep-alive表示我是支持长连接的，当完成一个请求后，试情况决定是否关闭连接。 一些 HTTP
	 * 服务器使用非标准的首部Keep-Alive来告诉客户端它们想在服务器端保持连接活动的周期秒数。如果这个信息存在， HttClient 就会使用它。
	 * 如果响应中Keep-Alive不存在， HttpClient会假定无限期地保持连接。 然而许多 HTTP
	 * 服务器的普遍配置是在特定非活动周期之后丢掉持久连接来保护系统资源，往往这是不通知客户端的。
	 * 
	 * 所以需要自定义的keep-alive策略： 
	 * 1.如果服务端在Response头部给了Keep-Alive，那我们就使用服务器提供的值 
	 * 2.为设定特定的服务器设置保持连接时间 
	 * 3.设置默认的保持连接时间
	 */
	private ConnectionKeepAliveStrategy myConnKAliveStrategy(final Map<String, Integer> KeepAliveRoutes,final long DefaultKeepAliveSeconds) {
		ConnectionKeepAliveStrategy myConnKAliveStrategy = new ConnectionKeepAliveStrategy() {

			public long getKeepAliveDuration(HttpResponse response, HttpContext context) {
				// Honor 'keep-alive' header
				HeaderElementIterator it = new BasicHeaderElementIterator(
						response.headerIterator(HTTP.CONN_KEEP_ALIVE));
				while (it.hasNext()) {
					HeaderElement he = it.nextElement();
					String param = he.getName();
					String value = he.getValue();
					if (value != null && param.equalsIgnoreCase("timeout")) {
						try {
							return Long.parseLong(value) * 1000;
						} catch (NumberFormatException ignore) {
						}
					}
				}

				HttpHost target = (HttpHost) context.getAttribute(HttpClientContext.HTTP_TARGET_HOST);
				if (KeepAliveRoutes.containsKey(target.getHostName())) {
					return KeepAliveRoutes.get(target.getHostName());
				} else {
					return DefaultKeepAliveSeconds;
				}
			}

		};

		return myConnKAliveStrategy;
	}

	/**
	 * RequestConfig是对request的一些配置。里面比较重要的有三个超时时间，默认的情况下这三个超时时间都为0
	 * 这也就意味着无限等待，很容易导致所有的请求阻塞在这个地方无限期等待。
	 * 在HttpClient配置了RequestConfig后，如果在构造request实例的时候不特别设置，这个httpClient处理的request都会使用这个默认配置
	 * 
	 * 这三个超时时间为： 
	 * 1. connectionRequestTimeout:从连接池中取连接的超时时间
	 * 2. connectTimeout:与服务器连接超时时间，建立socket连接的时间
	 * 3. socketTimeout:请求超时时间
	 * 
	 */
	public RequestConfig myRequestConfig(int connectionRequestTimeout, int connectTimeout, int socketTimeout) {

		RequestConfig reqConfig = RequestConfig.custom()
				.setConnectionRequestTimeout(connectionRequestTimeout)
				.setConnectTimeout(connectTimeout)
				.setSocketTimeout(socketTimeout).build();
		return reqConfig;
	}

	/**
	 * HttpRequestRetryHandler是Http请求出错后的重试的处理接口类 
	 * 已知实现类有:
	 * 1.DefaultHttpRequestRetryHandler
	 * 2.继承了DefaultHttpRequestRetryHandler的StandardHttpRequestRetryHandler
	 * 
	 * 该类里也实现了一个自定义的重试处理实现类，只有请求幂等(HTTP的GET、PUT、HEAD是幂等的)的时候，才会重发
	 * 
	 * 
	 */
	public HttpRequestRetryHandler myRetryHandler(int maxRetryTimes) {

		// return DefaultHttpRequestRetryHandler.INSTANCE;

		HttpRequestRetryHandler retryHandler = new HttpRequestRetryHandler() {

			@Override
			public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
				// Do not retry if over max retry count
				if (executionCount > maxRetryTimes) {
					return false;
				}

				// Timeout
				// if (exception instanceof InterruptedIOException) {
				// return false;
				// }
				// Unknown host
				if (exception instanceof UnknownHostException) {
					return false;
				}
				// Connection refused
				if (exception instanceof ConnectTimeoutException) {
					return false;
				}
				// SSL handshake exception
				if (exception instanceof SSLException) {
					return false;
				}

				HttpClientContext clientContext = HttpClientContext.adapt(context);
				HttpRequest request = clientContext.getRequest();
				boolean idempotent = !(request instanceof HttpEntityEnclosingRequest);
				if (idempotent) {
					// Retry if the request is considered idempotent
					return true;
				}
				return false;

			}

		};

		return retryHandler;

	}
	

	@PreDestroy
	public void destroyHttpClient() {
		if (httpClient != null) {
			try {
				logger.info("关闭HttpClient开始...");
				httpClient.close();
				logger.info("关闭HttpClient结束...");
			} catch (IOException e) {
				logger.error("HttpClient关闭失败...");
			}
		}
	}

	/****************************************to be delete*****************************************/

	
	
	// public ApacheInternalHttpClient(String configFile) {
	//
	// Registry<ConnectionSocketFactory> socketFactoryRegistry =
	// initSocketConnFactory();
	//
	// HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> connFactory =
	// initConnFactory();
	//
	// DnsResolver dnsResolver = initDnsResolver();
	//
	// //create a connection manager with custom configuration
	// PoolingHttpClientConnectionManager connManager = new
	// PoolingHttpClientConnectionManager(
	// socketFactoryRegistry, connFactory, dnsResolver);
	//
	// SocketConfig socketConfig = SocketConfig.custom()
	// .setTcpNoDelay(true)
	// .build();
	//
	//
	// }

	/**
	 * ConnectionSocketFactory用于创建、初始化和连接socket。
	 * 
	 * PlainConnectionSocketFactory是创建，初始化普通的socket（非加密socket）的工厂。
	 * ConnectionSocketFactory plainsf = PlainConnectionSocketFactory.INSTANCE
	 * 
	 * LayeredConnectionSocketFactory是ConnectionSocketFactory接口的拓展。
	 * 分层的socket工厂可以创建在已经存在的普通socket之上。套接字分层主要通过代理来创建安全的socket。
	 * SSLConnectionSocketFactory是LayeredConnectionSocketFactory的一个实现，用于建 SSL连接。
	 * SSLConnectionSocketFactory允许高度定制。它可以使用 javax.net.ssl.SSLContext 的实例作为参数，
	 * 并使用它来创建能够自定义配置的 SSL连接。
	 * 
	 * 自定义的Socket连接工厂可以关联特定的protocol scheme(HTTP/HTTPS),然后被用于创建一个自定义的连接管理器
	 * 
	 */

	private Registry<ConnectionSocketFactory> mySocketConnFactory() {
		SSLContext sslcontext = SSLContexts.createSystemDefault();
		Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
				.register("http", PlainConnectionSocketFactory.INSTANCE)
				.register("https", new SSLConnectionSocketFactory(sslcontext)).build();
		return socketFactoryRegistry;
	}

	private HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> initConnFactory() {

		HttpMessageParserFactory<HttpResponse> responseParserFactory = new DefaultHttpResponseParserFactory() {

			@Override
			public HttpMessageParser<HttpResponse> create(SessionInputBuffer buffer, MessageConstraints constraints) {
				LineParser lineParser = new BasicLineParser() {

					@Override
					public Header parseHeader(final CharArrayBuffer buffer) {
						try {
							return super.parseHeader(buffer);
						} catch (ParseException ex) {
							return new BasicHeader(buffer.toString(), null);
						}
					}

				};
				return new DefaultHttpResponseParser(buffer, lineParser, DefaultHttpResponseFactory.INSTANCE,
						constraints) {

					@Override
					protected boolean reject(final CharArrayBuffer line, int count) {
						// try to ignore all garbage preceding a status line infinitely
						return false;
					}

				};
			}

		};

		HttpMessageWriterFactory<HttpRequest> requestWriterFactory = new DefaultHttpRequestWriterFactory();

		HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> connFactory = new ManagedHttpClientConnectionFactory(
				requestWriterFactory, responseParserFactory);
		return connFactory;
	}

	private DnsResolver myDnsResolver() {
		DnsResolver dnsResolver = new SystemDefaultDnsResolver() {

			@Override
			public InetAddress[] resolve(final String host) throws UnknownHostException {
				if (host.equalsIgnoreCase("myhost")) {
					return new InetAddress[] { InetAddress.getByAddress(new byte[] { 127, 0, 0, 1 }) };
				} else {
					return super.resolve(host);
				}
			}

		};

		return dnsResolver;
	}





	public CloseableHttpClient getHttpClient() {
		return httpClient;
	}

}
