package com.practice.algo.bitwise;

public class MainClass {

	public static void main(String[] args) {
		int a[] = { 0, 1 };

		System.out.println("Before");
		System.out.println("arr[0] = " + a[0]);
		System.out.println("arr[1] = " + a[1]);
		changeToZero(a);

		System.out.println("After");
		System.out.println("arr[0] = " + a[0]);
		System.out.println("arr[1] = " + a[1]);
		
	}

	static void changeToZero(int[] a) {
		a[a[1]] = a[a[1] ^ 1];
	}

}
