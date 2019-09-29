package com.brightstar.http.client;
//package com.brightstar.http;
//
//import java.io.IOException;
//import java.nio.charset.Charset;
//import java.nio.charset.StandardCharsets;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.apache.http.HttpResponse;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.config.RequestConfig;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.util.EntityUtils;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.brightstar.http.client.prod.ProdHttpClient;
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class ConnectionTest {
//	
//	@Autowired
//	ProdHttpClient httpClient;
//	
//	static Gson gson = new GsonBuilder().create();
//	
//	
//	@Test
//	public void test1(){
//		try {
//			System.out.println(call("http://localhost:8080/cities"));
//		} catch (IOException e) {
//			System.out.print("cities exception");
//			e.printStackTrace();
//		}
//		
//		try {
//			System.out.println(call("http://localhost:8080/timeout?second=4"));
//		} catch (IOException e) {
//			System.out.print("timeout exception");
//			e.printStackTrace();
//		}
//	
//					
//			
//		try {
//			System.out.println(call("http://localhost:8080/home"));
//		} catch (IOException e) {
//			System.out.print("home exception");
//			e.printStackTrace();
//		}
//		
//		try {
//			System.out.println(call("http://localhost:8080/cities"));
//		} catch (IOException e) {
//			System.out.print("cities exception");
//			e.printStackTrace();
//		}
//		
//	}
//	
//	
//	
//	private String call(String url) throws ClientProtocolException, IOException {
//		HttpGet httpGet = new HttpGet(url);
//		RequestConfig config = RequestConfig.custom().setSocketTimeout(3*1000).build();
//		httpGet.setConfig(config );
//		 CloseableHttpResponse res = httpClient.getCloseableHttpClient().execute(httpGet);
////		 String ret = IOUtils.toString(res.getEntity().getContent(), "UTF-8");
//		 
////		 byte[] b = new byte[1000];
////		res.getEntity().getContent().read(b );
//		String responseContent = EntityUtils.toString(res.getEntity(), StandardCharsets.UTF_8); 
//		
////		res.close();
//		httpGet.releaseConnection();
//		return responseContent;
//	}
//	
//	
//	@Test
//	public void test() throws ClientProtocolException, IOException {
//
//        String name = "v1";
//        HttpGet httpGet = new HttpGet("http://localhost:8080/hello.get?name=" + name);
//        httpGet.setHeader("Content-Type", "application/json;charset=UTF-8");
//        HttpResponse httpResponse = httpClient.getCloseableHttpClient().execute(httpGet);
//        System.out.println("http.get:" + httpResponse.toString());
////
//        HttpPost httpPost = new HttpPost("http://localhost:8080/hello.post");
//        httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");
//        Map<String, String> params = new HashMap<String, String>();
//        params.put("name", "v1");
//        System.out.println("params:" + gson.toJson(params));
//        httpPost.setEntity(new StringEntity(gson.toJson(params), Charset.defaultCharset()));
//        httpResponse = httpClient.getCloseableHttpClient().execute(httpPost);
//        System.out.println("http.post:" + httpResponse.toString());
//	}
//
//}
