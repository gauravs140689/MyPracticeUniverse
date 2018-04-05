package com.practice.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainTest {

	public static void main(String[] args) {

		// testCallByRefInOverloadedMethods();
		// testDivideByZerodouble();
		// testSortingWithCollection();

		/*int[] intArray = new int[2];
		intArray.clone();*/
		
		Map<String, List<Integer>> map_ = new HashMap<>();
		map_.put("a", Arrays.asList(new Integer[]{1,2,3}));
		map_.put("b", Arrays.asList(new Integer[]{4,5,6}));
		
		map_.values().stream().forEach(System.out::println);
		map_.values().stream().flatMap(List::stream)
	}

	public static void testDivideByZerodouble() {
		System.out.println(2.0 / 0);
	}

	public static void test(Object s) {
		System.out.println("Object");
	}

	public static void test(Employee s) {
		System.out.println("Employee");
	}

	public static void test(Worker s) {
		System.out.println("Worker");
	}

	public static void testSortingWithCollection() {

		CustomeConcreteClass obj = new CustomeConcreteClass();
		obj.setName("Raj");
		obj.setGreeting("Hello");

		obj.printName();
		obj.greet();

		List<Employee> list = Arrays.asList(new Employee[] { new Employee(1, "Ram"), new Employee(2, "Raj"),
				new Employee(3, "Shyam"), new Employee(4, "Arjun"), new Employee(5, "Ram"), new Employee(6, "Arjun"),
				new Employee(7, "Ram"), new Employee(9, "Shyam"), new Employee(8, "Shyam") });

		list.stream().forEach(System.out::println);
		System.out.println("-------------------------------------------------------");
		list.stream().sorted((e1, e2) -> {
			if (e1.getName().equals(e2.getName())) {
				return e1.getId() - e2.getId();
			} else {
				return e1.getName().compareTo(e2.getName());
			}
		}).forEach(System.out::println);

		String[] arr = new String[] { "Ram", "Chandan", "Raj" };
		List<String> list1 = Arrays.asList(arr);
		Collections.sort(list1);
		list1.stream().forEach(System.out::println);

	}

	public static void testCallByRefInOverloadedMethods() {
		Worker e = new Employee();
		Employee e1 = null;
		String s = null;
		StringBuilder sb = null;

		test("Hello");
		test(new Employee());
		test(e);
		test(s);
		test(sb);
		test(e1);
		test(null);
		test(new Employee());

	}
}
