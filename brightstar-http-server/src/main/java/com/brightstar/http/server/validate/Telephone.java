package com.brightstar.http.server.validate;

import javax.validation.constraints.NotBlank;

public class Telephone {
	
	@NotBlank(message="telephone 不能为空")
	String phoneNumber;

	public Telephone() {}
	
	public Telephone(@NotBlank(message = "telephone 不能为空") String phoneNumber) {
		super();
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
