package com.practice.java.generics;

import java.util.ArrayList;
import java.util.List;

public class SimpleGenericClass<T extends Animal> {
	
	List<T> currentList = new ArrayList<>();
	
	public <X extends T> void born(X animal){
		currentList.add(animal);
	}
	
	public boolean die(T animal){
		return currentList.remove(animal);
	}
	
	public List<T> getCurrentList(){
		return currentList;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(T animal: currentList){
			sb.append(animal.type);
			sb.append("  ");
		}
		if(currentList.size()>1)
			sb.append("are Alive");
		else if(currentList.size()==1)
			sb.append("is Alive");
		else if(currentList.size()==0)
			sb.append("All Dead");
		return sb .toString();
	}

}
