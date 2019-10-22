package com.brightstar.http.server.validate;

import javax.validation.constraints.NotBlank;

public class Home {
	
	@NotBlank(message="address 不能为空")
	String address;

	public Home() {}
	
	public Home(@NotBlank(message = "address 不能为空") String address) {
		super();
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	

}
