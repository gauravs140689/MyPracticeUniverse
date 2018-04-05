package com.practice.java.thread.interrupt;

public class MainClass {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("Main Start");
		
		InterruptDemoThread1 r1 = new InterruptDemoThread1();
		InterruptDemoThread2 r2 = new InterruptDemoThread2();
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		
		t1.start();
		t2.start();
		t2.interrupt();
		Thread.sleep(10000);
		t1.join(1000);
		Thread.sleep(10000);
		t1.interrupt();
		
		System.out.println("Main End");
	}

}
