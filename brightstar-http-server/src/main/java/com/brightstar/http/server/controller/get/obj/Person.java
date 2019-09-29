package com.brightstar.http.server.controller.get.obj;

public class Person {


	String name;
	
	int age;
	
	boolean gender;

	
	public Person(String name, int age, boolean gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}


	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
	
}
