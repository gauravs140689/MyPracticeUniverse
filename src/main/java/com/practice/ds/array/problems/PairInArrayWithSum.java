package com.practice.ds.array.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import com.practice.problems.Problem;
import com.practice.util.CommonUtility;

public class PairInArrayWithSum implements Problem{
	
	ArrayList<Integer> inputArray = new ArrayList<>();
	int sum = 8;

	@Override
	public void init(Object o) {
		if(o != null)
			inputArray = (ArrayList<Integer>) o;
		else{
			inputArray.add(1);
			inputArray.add(4);
			inputArray.add(3);
			inputArray.add(9);
			inputArray.add(5);
			inputArray.add(-1);
		}
		
		System.out.println("Input Array: "+inputArray.toString());
	}

	@Override
	public void solve() {

		solve1();
		solve2();
		
		
	}

	@Override
	public void printOutput() {
		
	}
	
	public void solve1(){
		System.out.println("Solution 1");
		if(inputArray == null)
			init(null);
		
		Collections.sort(inputArray, (a,b) -> a - b);//mergesort
		System.out.println("Sorted Array: "+inputArray.toString());
		
		
		int l = 0;
		int r = inputArray.size()-1;
		
		while (l<r){//worst case n iteration
			if(inputArray.get(l) + inputArray.get(r) == sum){
				System.out.println("Pair : "+inputArray.get(l)+" , "+inputArray.get(r));
				l++;r--;
			}else if (inputArray.get(l) + inputArray.get(r) < sum)
				l++;
			else
				r--;
		}
		
	}
	
	public void solve2(){
		System.out.println("Solution 2");
		
		//Using hashing
		//http://www.geeksforgeeks.org/write-a-c-program-that-given-a-set-a-of-n-numbers-and-another-number-x-determines-whether-or-not-there-exist-two-elements-in-s-whose-sum-is-exactly-x/
		
	}

}
