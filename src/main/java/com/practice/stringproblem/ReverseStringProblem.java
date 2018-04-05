package com.practice.stringproblem;

import java.util.Stack;

import com.practice.problems.Problem;

public class ReverseStringProblem implements Problem {

	String inputString = "I am rock";
	long time_arary;
	long time_stack;

	@Override
	public void init(Object o) {
		if(o instanceof String)
			inputString = (String) o;
		else
			System.out.println("InputString : " + inputString);
	}

	@Override
	public void solve() {
		
		long start_array = System.currentTimeMillis();
		reverseUsingArray(inputString);
		long end_array = System.currentTimeMillis();
		reverseUsingStack(inputString);
		long end_stack = System.currentTimeMillis();
		time_arary = end_array-start_array;
		time_stack = end_stack-end_array;
	}

	private void reverseUsingArray(String s) {
		// Using Array
		System.out.println("Using Array");
		char[] cArr = s.toCharArray();

		for (int i = 0; i <= s.length() / 2; i++) {
			char temp = cArr[i];
			cArr[i] = cArr[s.length() - 1 - i];
			cArr[s.length() - 1 - i] = temp;
		}
		for (char c : cArr) {
			System.out.print(c);
		}
		System.out.println("\n");
	}

	private void reverseUsingStack(String s) {
		// Using Stack
		System.out.println("Using Stack");
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			stack.push(s.charAt(i));
		}

		while (!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
		System.out.println("\n");
	}

	@Override
	public void printOutput() {
		
		System.out.println("Time Taken Using Array : "+(time_arary) +" ms");
		System.out.println("Time Taken Using Array : "+(time_stack) +" ms");
	}

}
