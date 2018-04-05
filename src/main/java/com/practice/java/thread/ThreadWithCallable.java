package com.practice.java.thread;

import java.util.Random;
import java.util.concurrent.Callable;

public class ThreadWithCallable implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		
		Random random = new Random();
		return random.nextInt();
	}

}
