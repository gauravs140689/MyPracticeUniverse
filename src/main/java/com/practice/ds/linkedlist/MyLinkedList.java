package com.practice.ds.linkedlist;

public class MyLinkedList<T> {

	Node<T> head;
	
	public MyLinkedList(){
	}
	
	@SafeVarargs
	public MyLinkedList(T ...values){
		createLinkedList(values);
	}
	
	/**
	 * Values are in a string: comma separated
	 * @param values
	 * @return 
	 */
	private void createLinkedList(T[] listValues){
		for(T data: listValues){
			addElement(data);
		}
	}
	
	
	public boolean addElement(T data){
		
		if(this.head == null ){
			this.head = new Node<T>(data);
		}else{
			Node<T> temp = this.head;
			while(temp.getNext()!=null){
				temp = temp.getNext();
			}
			temp.setNext(new Node<T>(data));
		}
		
		return true;
	}
	
	/**
	 * Print all elements of LinkedList
	 */
	public void printLinkedList(){
		
		StringBuilder fLine = new StringBuilder();
		StringBuilder sLine = new StringBuilder();
		StringBuilder tLine = new StringBuilder();
		StringBuilder foLine = new StringBuilder();
		StringBuilder fiLine = new StringBuilder();
		
		Node<T> temp = this.head;
		fLine.append("        ");
		sLine.append("        ");
		tLine.append("head -->");
		foLine.append("        ");
		
		while(temp!=null){
			
			fLine.append(" _");
			sLine.append("| ");
			tLine.append("| "+temp.getData()+" | --|--->");
			foLine.append("|_");
			for(int i=1;i<=temp.getData().toString().length();i++){
				fLine.append("_");
				sLine.append(" ");
				foLine.append("_");
			}
			fLine.append("_____     ");
			sLine.append(" |   |    ");
			foLine.append("_|___|    ");
			
			temp = temp.getNext();
		}
		tLine.append("NULL");
		System.out.println(fLine.toString());
		System.out.println(sLine.toString());
		System.out.println(tLine.toString());
		System.out.println(foLine.toString());
		
	}

}
