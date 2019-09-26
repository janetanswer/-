package com.brightstar.http.client.apache.interceptor;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.client.entity.GzipDecompressingEntity;
import org.apache.http.protocol.HttpContext;
import org.springframework.stereotype.Component;

/**
 * 该类包含了很多HttpResponseInterceptor接口的实现，用于处理HttpResponse协议的一部分
 * map中存放了所有预先定义的HttpResponseInterceptor，每个实现有一个唯一的名字。
 * 可以通过配置InterceptorConfig#responseInterceptorNames来指定HttpClient初始化的时候加载哪些HttpResponseInterceptor
 * 
 */
//@Component
public class ResponseInterceptor {
	
	Map<String,HttpResponseInterceptor> map = new HashMap<String,HttpResponseInterceptor>();
	
	@PostConstruct
	public void init() {
		map.put("requestInterceptor", responseInterceptor);
	}
	
	 HttpResponseInterceptor responseInterceptor = new HttpResponseInterceptor() {
         @Override
         public void process(HttpResponse response, HttpContext context) throws
         HttpException, IOException {
            System.out.println("Adding header sample_header, demo-header, test_header to the response");
            response.setHeader("sample-header", "My first header");
            response.setHeader("demo-header", "My second header");
            response.setHeader("test-header", "My third header"); 
         }
      };
      
      HttpResponseInterceptor responseInterceptor2 = new HttpResponseInterceptor() {
          @Override
          public void process(final HttpResponse r, final HttpContext context) throws HttpException, IOException
          {
//            assertEquals(200, r.getStatusLine().getStatusCode());
//            assertNotNull(r.getHeaders(HttpHeaders.CONTENT_ENCODING));
//            assertEquals(1, r.getHeaders(HttpHeaders.CONTENT_ENCODING).length);
//            assertEquals("gzip", r.getHeaders(HttpHeaders.CONTENT_ENCODING)[0].getValue());
          }
       };

       
       HttpResponseInterceptor responseInterceptor3 = new HttpResponseInterceptor() {
           @Override
           public void process(HttpResponse res, HttpContext ctx)
                   throws HttpException, IOException {
               HttpEntity entity = res.getEntity();
               if (entity != null) {
                   Header contentEncoding = res
                           .getFirstHeader("Content-Encoding");
                   if (contentEncoding != null
                           && contentEncoding.getValue().equalsIgnoreCase(
                                   "gzip")) {
                       res.setEntity(new GzipDecompressingEntity(entity));
                       return;
                   }
               }
           }
        };

	public Map<String, HttpResponseInterceptor> getMap() {
		return map;
	}


	public void setMap(Map<String, HttpResponseInterceptor> map) {
		this.map = map;
	}

}
