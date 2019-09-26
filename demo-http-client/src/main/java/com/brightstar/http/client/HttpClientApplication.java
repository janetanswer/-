package com.brightstar.http.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication()
@EnableAsync
public class HttpClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(HttpClientApplication.class, args);
	}

}
