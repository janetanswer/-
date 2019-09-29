package com.brightstar.http.client;


import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.client.utils.URIBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.brightstar.http.client.apache.ApacheInternalHttpClient;
import com.brightstar.http.client.apache.HttpTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientTest {

	@Autowired
//	ApacheMinimalHttpClient hc;
	ApacheInternalHttpClient hc;
	
	@Autowired
	HttpTemplate httpTemplate;

	@Test
	public void testKeepSocket() throws URISyntaxException {
//		URI uri = new URIBuilder().setScheme("http").setHost("127.0.0.1").setPort(8080).setPath("/hello.get").setParameter("name", "janetanswer").build();
//		httpTemplate.get(hc.getHttpClient(), uri);
//		
//		
//		URI uri2 = new URIBuilder().setScheme("http").setHost("127.0.0.1").setPort(8080).setPath("/hello.get").setParameter("name", "answer").build();
//		httpTemplate.get(hc.getHttpClient(), uri2);
		
		
		for(int i=0;i<5;i++) {
			URI uri3 = new URIBuilder().setScheme("http").setHost("127.0.0.1").setPort(8080).setPath("/hello.get").setParameter("name", ""+i).build();
			httpTemplate.get(hc.getHttpClient(), uri3);
		}
		
		try {
			Thread.sleep(10*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
//	ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
//
//		@Override
//		public String handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
//			StatusLine statusLine = response.getStatusLine();
//			HttpEntity entity = response.getEntity();
//			if (statusLine.getStatusCode() >= 300) {
//				throw new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase());
//			}
//			if (entity == null) {
//				throw new ClientProtocolException("Response contains no content");
//			}
//
//			return EntityUtils.toString(entity);
//		}
//
//	};
//
//	@Test
//	public void test_socketConnect() {
//		URI uri = null;
//		try {
//			uri = new URIBuilder().setScheme("http").setHost("127.0.0.1").setPort(8080).setPath("/hello.get").setParameter("name", "janetanswer").build();
//		} catch (URISyntaxException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		HttpGet httpGet = new HttpGet(uri);
//
//		try {
//			String responseBody = apacheMinimalHttpClient.getHttpClient().execute(httpGet, responseHandler);
//			System.out.print("responseBody----"+responseBody);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}
