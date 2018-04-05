package com.practice.ds.linkedlist;

public class MainClass {

	public static void main(String[] args) {

		System.out.println(-4 >> 2);
		// LinkedList<Integer> ls = new LinkedList<>(1,2,3,4);

		MyLinkedList<Integer> ls = new MyLinkedList<>(1, 2, 4, 56, 10000);
		ls.printLinkedList();

		/*
		 * for(String s:ls){
		 * 
		 * }
		 */
	}

}
