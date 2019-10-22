package com.brightstar.http.server.validate;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Response<T> {
	
	private T data;
	private String retmsg;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime retDateTime;

	public Response() {
		super();
	}

	public Response(T data, String retmsg, LocalDateTime retDateTime) {
		super();
		this.data = data;
		this.retmsg = retmsg;
		this.retDateTime = retDateTime;
	}
	
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getRetmsg() {
		return retmsg;
	}

	public void setRetmsg(String retmsg) {
		this.retmsg = retmsg;
	}

	public LocalDateTime getRetDateTime() {
		return retDateTime;
	}

	public void setRetDateTime(LocalDateTime retDateTime) {
		this.retDateTime = retDateTime;
	}
}
