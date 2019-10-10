package com.brightstar.http.server.validate.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.brightstar.http.server.validate.Bean4Validate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProcesserValidateTest {

	@Autowired
	Processer processer;
	
	@Test
	public void test() {
		Bean4Validate bean = Bean4Validate.getTureBean();
		bean.setAge(8);
		System.out.println(processer.process(bean));
	}

}
