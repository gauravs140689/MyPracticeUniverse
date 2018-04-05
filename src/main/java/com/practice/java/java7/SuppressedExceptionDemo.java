package com.practice.java.java7;

import java.io.IOException;

public class SuppressedExceptionDemo {
	
	public static void main(String[] args){
		
		try{
			(new SuppressedExceptionDemo()).methodWithTryWithResorces();
		}catch(Exception e){
			Throwable[] eth = e.getSuppressed();
			System.err.println(e.getClass());
			System.out.println();
			System.out.println("Suppressed Exception................");
			for(Throwable te : eth){
				System.out.println(te.getClass());
			}
		}
		
		
	}
	
	public void methodWithTryWithResorces() throws Exception{
		
		try(MyAutoCloseable obj = new MyAutoCloseable()){
			int i = 5/0;
		}
	}

}

class MyAutoCloseable implements AutoCloseable{

	public void close() throws Exception {
		throw new IOException();
	}
	
}