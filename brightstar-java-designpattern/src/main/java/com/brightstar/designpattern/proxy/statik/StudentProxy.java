package com.brightstar.designpattern.proxy.statik;

public class StudentProxy implements Person{
	
	Student student;

	@Override
	public void report() {
		System.out.println("Proxy report");
		if(student!=null) {
			student.report();
		}
		
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
