package com.brightstar.http.client.controller.get.obj;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.brightstar.http.server.controller.get.obj.GetObjResponse;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GetObjControllerTest {
	
	
	
	
	@Test
	public void test_getOrder_validate_error() {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/brightstar/getobj";
		
		ResponseEntity<GetObjResponse> ret =restTemplate.getForEntity(url, GetObjResponse.class);
		
		System.out.println("***GetObjControllerTest Result***\n"+ret.getBody().toString());
	}

}
