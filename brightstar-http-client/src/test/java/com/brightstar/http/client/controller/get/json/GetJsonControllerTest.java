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
	 * ʹ�����½ӿ�������GET���͵�http����
	 * @Nullable
	 * public <T> T getForObject(URI url, Class<T> responseType) throws RestClientException;	 
	 *  
	 *  ע�����
	 *  1. ��Ҫ���л����࣬������ǰ�˽�����rpc���ã��������޲ι������������ԱȽϺ�
	 */
	@Test
	public void test_getJson_getOrderByPerson_1() {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/brightstar/getjson/getOrderByPerson?name=key&age=8&gender=true";
		
		ResponseEntity<Order> ret = restTemplate.getForEntity(url, Order.class);
		
		System.out.println("***GetObjControllerTest Result***\n"+ret.getBody().toString());
	}
	
	
	/**
	 * ʹ�����½ӿ�������GET���͵�http����
	 * @Nullable
	 * public <T> T getForObject(String url, Class<T> responseType, Object... uriVariables) throws RestClientException ;
	 * 
	 * ע�����
	 * 1. url�е�ռλ����?
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
	 * ʹ�����½ӿ�������GET���͵�http����
	 * @Nullable
	 * public <T> T getForObject(String url, Class<T> responseType, Map<String, ?> uriVariables) throws RestClientException ;
	 * 
	 * ע�����
	 * 1. url�е�ռλ��������
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
