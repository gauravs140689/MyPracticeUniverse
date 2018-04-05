package com.practice.test;

public class SingletonTest {
	
	private int counter;
	
	private static SingletonTest singleObject;
	
	private SingletonTest(){
		
	}
	
	public static SingletonTest getInstance(){
		if(singleObject==null){
			synchronized (SingletonTest.class) {
				if(singleObject==null)
					singleObject = new SingletonTest();
			}
		}
		return singleObject;
	}
	
	public void connect(){
		counter++;
		System.out.println(this.counter);
	}

}
