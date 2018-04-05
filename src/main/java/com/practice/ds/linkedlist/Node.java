package com.practice.ds.linkedlist;

public class Node<T> {

	private T data;
	private Node<T> next;

	Node(T data) {
		this.data = data;
	}
	
	Node(T data, Node<T> next) {
		this.data = data;
		this.next = next;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public T getData() {
		return this.data;
	}

}
