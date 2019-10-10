package com.brightstar.http.server.validate.service;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.brightstar.http.server.validate.Bean4Validate;
import com.brightstar.http.server.validate.Response;

@Component
public class Processer {

	@ExceptionHandler(value = { ConstraintViolationException.class })
	public String process(@Valid Bean4Validate request) {
		
		return "success";
	}
}
