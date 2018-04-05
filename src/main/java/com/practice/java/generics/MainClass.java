package com.practice.java.generics;

public class MainClass {
	
	public static void main(String[] args){
		
		Cat c1 = new Cat("Cat1");
		Cat c2 = new Cat("Cat2");
		
		Dog dog1 =new Dog("Dog1");
		Dog dog2 =new Dog("Dog2");
		
		SimpleGenericClass<Animal> zooCatList = new SimpleGenericClass<>();
		SimpleGenericClass<Dog> zooDogList = new SimpleGenericClass<>();
		
		zooCatList.born(c1);
		zooCatList.born(c2);
		
		zooDogList.born(dog1);
		zooDogList.born(dog2);
		
		System.out.println(zooCatList);
		System.out.println(zooDogList);
		
		zooDogList.die(dog1);
		zooCatList.die(c2);
		
		System.out.println(zooCatList);
		System.out.println(zooDogList);
		
		zooDogList.die(dog2);
		checkRemovalOfGenricForJVM(zooCatList);
		
		System.out.println(zooCatList);
		System.out.println(zooDogList);
		
		
		
	}

	private static void checkRemovalOfGenricForJVM(SimpleGenericClass<? extends Animal> sgc){
		System.out.println("");
	}
}
