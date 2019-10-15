package com.brightstar.http.server.validate.service;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.groups.Default;

import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.brightstar.http.server.validate.Bean4Validate;

@Component
@Validated(Default.class)
public class Processer {

	@ExceptionHandler(value = { ConstraintViolationException.class })
	public String process(@Valid Bean4Validate request) {
		
		return "success";
	}
}
