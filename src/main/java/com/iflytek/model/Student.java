package com.iflytek.model;

public class Student {
	
	private String className;
	private String name;
	private Integer age;
	public Student() {
	}
	public Student(String className, String name, Integer age) {
		this.className = className;
		this.name = name;
		this.age = age;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [className=" + className + ", name=" + name + ", age=" + age + "]";
	}
	
	
	
}
