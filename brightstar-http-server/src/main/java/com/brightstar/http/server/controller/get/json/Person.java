package com.brightstar.http.server.controller.get.json;


public class Person {


	String name;
	
	int age;
	
	boolean gender;

	public Person(){}
	
	
	public Person(String name, int age, boolean gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public boolean isGender() {
		return gender;
	}


	public void setGender(boolean gender) {
		this.gender = gender;
	}


	@Override
	public String toString() {
		return "JsonRequest [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}


	
	
}
