package com.brightstar.http.client.apache.interceptor;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;
import org.springframework.stereotype.Component;

/**
 * 该类包含了很多HttpRequestInterceptor接口的实现，用于处理HttpRequest协议的一部分
 * map中存放了所有预先定义的HttpRequestInterceptor，每个实现有一个唯一的名字。
 * 可以通过配置InterceptorConfig#requestInterceptorNames来指定HttpClient初始化的时候加载哪些HttpRequestInterceptor
 * 
 */
//@Component
public class RequestInterceptor {
	
	
	/**
	 * key:InterceptorConfig#requestInterceptorNames中的元素
	 * value:实际的HttpRequestInterceptor
	 */
	Map<String,HttpRequestInterceptor> map = new HashMap<String,HttpRequestInterceptor>();
	
	@PostConstruct
	public void init() {
		map.put("requestInterceptor", requestInterceptor);
	}

	
	HttpRequestInterceptor requestInterceptor = new HttpRequestInterceptor() {
        @Override
        public void process(HttpRequest request, HttpContext context) throws
        HttpException, IOException {
           if(request.containsHeader("sample-header")) {
              System.out.println("Contains header sample-header, removing it..");
              request.removeHeaders("sample-header"); 
           }
           //Printing remaining list of headers
           Header[] headers= request.getAllHeaders();
           for (int i = 0; i<headers.length;i++) {
              System.out.println(headers[i].getName());
           }
        }
     };

     
     
     
     
     
     
	public Map<String, HttpRequestInterceptor> getMap() {
		return map;
	}


	public void setMap(Map<String, HttpRequestInterceptor> map) {
		this.map = map;
	}





	
	
	

}
