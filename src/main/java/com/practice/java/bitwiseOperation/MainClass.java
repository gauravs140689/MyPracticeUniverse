package com.practice.java.bitwiseOperation;

/**
 * @author gaurakum
 *
 */
public class MainClass {

	public static void main(String[] args) {

		int a = -60; /* 60 = 0011 1100 */
		int b = 13; /* 13 = 0000 1101 */
		int c = 0;
		
		System.out.println("a="+a+", b="+b+", c="+c);

		c = a & b; /* 12 = 0000 1100 */
		System.out.println("a & b = " + c);

		c = a | b; /* 61 = 0011 1101 */
		System.out.println("a | b = " + c);

		c = a ^ b; /* 49 = 0011 0001 */
		System.out.println("a ^ b = " + c);

		c = ~a; /*-61 = 1100 0011 */
		System.out.println("~a = " + c);

		c = a << 2; /* 240 = 1111 0000 */
		System.out.println("a << 2 = " + c);
		System.out.println("Note: num << 1 == num*2");

		c = a >> 2; /* 15 = 1111 */
		System.out.println("a >> 2  = " + c);
		System.out.println("Note: num >> 1 == num/2");

		c = a >>> 2; /* 15 = 0000 1111 */
		System.out.println("a >>> 2 = " + c);

		// Check Even and ODD
		System.out.println("Checking Even or Odd");
		System.out.println(isNumberEven(5));
		System.err.println(isNumberEven(99));
		System.err.println(isNumberEven(6));
		
	}

	
	/**
	 * 
	 * This is checked by Bitwise operator.
	 * 
	 * @param num any positive number
	 * @return This method will return true if num is Even else false.
	 * 
	 */
	public static boolean isNumberEven(int num) {
		if (1 == (num & 1)) {
			return false;
		} else {
			return true;
		}
	}

}
