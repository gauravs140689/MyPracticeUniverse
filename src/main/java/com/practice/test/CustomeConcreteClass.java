package com.practice.test;

public class CustomeConcreteClass extends CustomAbstractClass{

	public String name;
	
	@Override
	public void setName(String name) {
		this.name = name+":";
	}
	
}
