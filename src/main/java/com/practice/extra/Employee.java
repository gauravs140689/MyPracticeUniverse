package com.practice.extra;
public class Employee {
	
	int id;
	String name;
	int age;
	String company;
	String status;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Employee(int id, String name, int age, String company, String status) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.company = company;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", company=" + company + ", status=" + status
				+ "]";
	}
	
	
	
}
