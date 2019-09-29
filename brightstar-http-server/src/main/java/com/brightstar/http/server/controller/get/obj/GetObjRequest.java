package com.brightstar.http.server.controller.get.obj;

import javax.validation.constraints.NotEmpty;

public class GetObjRequest{
	
	@NotEmpty(message="版本号不能为空！")
	String verison;
	
	Person person;

	public GetObjRequest(String verison, Person person) {
		super();
		this.verison = verison;
		this.person = person;
	}

	@Override
	public String toString() {
		return "GetObjRequest [verison=" + verison + ", person=" + person + "]";
	}
	
	

}
