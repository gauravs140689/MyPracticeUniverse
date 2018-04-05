package com.practice.test;

public abstract class CustomAbstractClass {
	
	protected String name;
	private String greeting;
	
	public void setGreeting(String greeting){
		this.greeting = greeting;
	}
	
	public void printName(){
		System.out.println("Name From Abstract: "+name);
	}
	
	public abstract void setName(String name);
	
	public void greet(){
		System.out.println("Greeting From Abstract: "+greeting);
	}

}
