package com.practice;

import com.practice.algo.dynamicprogramming.problem.FibonacciNumberProblem;
import com.practice.ds.array.problems.PairInArrayWithSum;
import com.practice.problems.Problem;

public class MainForProblem {
	
	public static void  main(String[] args){
		
		//Reverse String Problem
		/*Problem rStringProb = new ReverseStringProblem();
		rStringProb.init(0);
		rStringProb.solve();
		rStringProb.printOutput();*/
		
		//PairInArrayWithSum
		/*Problem pairInArrayWithSum = new PairInArrayWithSum();
		pairInArrayWithSum.init(null);
		pairInArrayWithSum.solve();
		pairInArrayWithSum.printOutput();*/
		
		
		//Fibonacci Problem with dp (bottom to up)
		Problem fibProb = new FibonacciNumberProblem();
		fibProb.init(new Integer(47));
		long start = System.currentTimeMillis();
		fibProb.solve();
		long end = System.currentTimeMillis();
		System.out.println();
		
		//Without DP
		long start_1 = System.currentTimeMillis();
		int first = 0;
		int second = 1;
		int curr=0;
		System.out.print(first+"  ");
		System.out.print(second+"  ");
		for(int i=2;i<=10;i++){
			curr = first+second;
			first = second;
			second=curr;
			System.out.print(curr+"  ");
		}
		long end_1 = System.currentTimeMillis();
		
		System.out.println();
		System.out.println("DP- "+(end-start) +"ms");
		
		
		System.out.println();
		System.out.println("Without DP- "+(end_1-start_1) +"ms");
	}

}
