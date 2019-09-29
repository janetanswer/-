package com.brightstar.http.server.controller.get.json;

import lombok.Data;
import lombok.ToString;

//集合了@ToString、@EqualsAndHashCode、@Getter/@Setter、@RequiredArgsConstructor的所有特性
@Data 
public class JsonRequest {


	String name;
	
	int age;
	
	boolean gender;

	public JsonRequest(){}
	
	
	public JsonRequest(String name, int age, boolean gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}


	
	
}
