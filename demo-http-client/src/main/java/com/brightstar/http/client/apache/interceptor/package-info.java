/**
	 * HttpProcessor:接口，继承了HttpRequestInterceptor和HttpResponseInterceptor。
	 * 说明整个process过程就是要进行HttpRequest和HttpResponse处理。
	 * 它有一个实现类：ImmutableHttpProcessor，
	 * 这个实现类含有final的HttpRequestInterceptor数组和HttpResponseInterceptor数组，
	 * 整个process过程就是将所有的HttpRequestInterceptor和HttpResponseInterceptor都process一遍。
	 * 
	 * HttpRequestInterceptor(#process):接口。
	 * 每个实现类用于处理HttpRequest协议的一部分，
	 * 如RequestClientConnControl、RequestAuthCache、RequestAddCookies等。
	 * 
	 * HttpResponseInterceptor(#process):接口。
	 * 每个实现类用于处理HttpResponse协议的一部分，
	 * 如RequestAcceptEncoding、RequestAuthCache等。
	 */

package com.brightstar.http.client.apache.interceptor;