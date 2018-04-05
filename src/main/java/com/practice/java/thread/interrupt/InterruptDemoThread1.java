package com.practice.java.thread.interrupt;

public class InterruptDemoThread1 implements Runnable{

	@Override
	public void run() {
		System.out.println("InterruptDemoThread1 Start");
			
		for(int i=0;i<10000;i++){
			System.out.print("\r"+i);
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("InterruptDemoThread1 End");
	}


}


