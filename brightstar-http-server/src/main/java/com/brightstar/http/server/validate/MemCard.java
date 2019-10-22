package com.brightstar.http.server.validate;

import javax.validation.constraints.NotBlank;

public class MemCard {

	@NotBlank(message="memno 不能为空")
	String memno;
	
	public MemCard() {}
	
	public MemCard(@NotBlank(message = "memno 不能为空") String memno) {
		super();
		this.memno = memno;
	}

	public String getMemno() {
		return memno;
	}

	public void setMemno(String memno) {
		this.memno = memno;
	}


	
}
