package com.practice.algo.dynamicprogramming.problem;

import java.net.StandardSocketOptions;

import com.practice.problems.Problem;

public class FibonacciNumberProblem implements Problem{
	
	private int n;
	
	

	@Override
	public void init(Object o) {
		n = (Integer)o;
	}

	@Override
	public void solve() {
		//Fn = Fn-1 + Fn-2
		// 0 1 1 2 ..
		
		int[] mem = new int[n+1];
		mem[0] = 0;
		mem[1] = 1;
		
		System.out.print(mem[0]+"  ");
		System.out.print(mem[1]+"  ");

		for(int i=2;i<=n;i++){
			
			try{
				mem[i] = mem[i-1] + mem[i-2];
				System.out.print(mem[i]+"  ");
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void printOutput() {
		
	}

}
