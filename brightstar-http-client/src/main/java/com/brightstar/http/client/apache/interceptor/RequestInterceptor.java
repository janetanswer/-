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
 * ��������˺ܶ�HttpRequestInterceptor�ӿڵ�ʵ�֣����ڴ���HttpRequestЭ���һ����
 * map�д��������Ԥ�ȶ����HttpRequestInterceptor��ÿ��ʵ����һ��Ψһ�����֡�
 * ����ͨ������InterceptorConfig#requestInterceptorNames��ָ��HttpClient��ʼ����ʱ�������ЩHttpRequestInterceptor
 * 
 */
//@Component
public class RequestInterceptor {
	
	
	/**
	 * key:InterceptorConfig#requestInterceptorNames�е�Ԫ��
	 * value:ʵ�ʵ�HttpRequestInterceptor
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
