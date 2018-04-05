package com.practice.util;

import java.util.List;

public class CommonUtility {

	public static void printStaticArray(Object o, String className) throws ClassNotFoundException{
		Class<?> cls = Class.forName(className);
	
		
	}
	
	public static void printArrayList(List l){
		
		boolean isFisrt = true;
		System.out.println();
		System.out.print("[");
		for(Object e: l){
			if(isFisrt)
				isFisrt=false;
			else
				System.out.print(",");
			System.out.print(e.toString());
		}
		
		System.out.print("]");
		System.out.println();
	}
}
