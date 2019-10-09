package com.brightstar.http.client.controller.get.json;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.brightstar.http.server.controller.get.json.Order;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GetJsonControllerTest {
	
	
	/**
	 * 使用以下接口来进行GET类型的http调用
	 * @Nullable
	 * public <T> T getForObject(URI url, Class<T> responseType) throws RestClientException;	 
	 *  
	 *  注意事项：
	 *  1. 需要序列化的类，比如与前端交互，rpc调用，都加上无参构造器，兼容性比较好
	 */
	@Test
	public void test_getJson_getOrderByPerson_1() {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/brightstar/getjson/getOrderByPerson?name=key&age=8&gender=true";
		
		ResponseEntity<Order> ret = restTemplate.getForEntity(url, Order.class);
		
		System.out.println("***GetObjControllerTest Result***\n"+ret.getBody().toString());
	}
	
	
	/**
	 * 使用以下接口来进行GET类型的http调用
	 * @Nullable
	 * public <T> T getForObject(String url, Class<T> responseType, Object... uriVariables) throws RestClientException ;
	 * 
	 * 注意事项：
	 * 1. url中的占位符是?
	 * 
	 */
	@Test
	public void test_getJson_getOrderInfo_2() {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/brightstar/getjson/getOrderByPerson?name={?}&age={?}&gender={?}";
		
		ResponseEntity<Order> ret = restTemplate.getForEntity(url, Order.class, "key",8,true);
		
		System.out.println("***GetObjControllerTest Result***\n"+ret.getBody().toString());
	}
	
	
	/**
	 * 使用以下接口来进行GET类型的http调用
	 * @Nullable
	 * public <T> T getForObject(String url, Class<T> responseType, Map<String, ?> uriVariables) throws RestClientException ;
	 * 
	 * 注意事项：
	 * 1. url中的占位符是名称
	 */
	@Test
	public void test_getJson_getOrderByPerson_3() {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/brightstar/getjson/getOrderByPerson?name={name}&age={age}&gender={gender}";
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("name", "key");
		params.put("age", 8);
		params.put("gender", true);
		
		ResponseEntity<Order> ret = restTemplate.getForEntity(url, Order.class, params);
		
		System.out.println("***GetObjControllerTest Result***\n"+ret.getBody().toString());
	}
	
	


}
