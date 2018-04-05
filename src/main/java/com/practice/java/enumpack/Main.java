package com.practice.java.enumpack;

public class Main {
	
	public static void main(String ...args){
		Operator plusOperator  =  ArithmaticOperator.fromOperatorCode("add");
		Operator minusOperator  =  ArithmaticOperator.fromOperatorCode("sub");
		Operator noneOperator = ArithmaticOperator.fromOperatorCode("none");
		
		System.out.println(ArithmaticOperator.PLUS.toString()+" : "+plusOperator.apply(5, 6));
		System.out.println(ArithmaticOperator.MINUS.toString()+" : "+minusOperator.apply(5, 6));
		
		System.out.println(ArithmaticOperator.NONE.toString()+" : "+noneOperator.apply(5, 6));		
	}

}
