package com.practice.java.thread.interrupt;

public class InterruptDemoThread2 implements Runnable{

	@Override
	public void run() {
		System.out.println("InterruptDemoThread2 Start");
		
		char c = 'a';
		for(int i=c;i<c+26;i++){
			System.out.println((char)i);
			if(Thread.interrupted())
				System.out.println("InterruptDemoThread2 Interrupted");
		}
		
		System.out.println("InterruptDemoThread2 End");
	}

}
