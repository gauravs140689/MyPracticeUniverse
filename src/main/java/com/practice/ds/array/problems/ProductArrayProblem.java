package com.practice.ds.array.problems;

import java.io.Serializable;

import com.practice.problems.Problem;

/**
 * @author gaurakum
 * 
 *         Problem : product array is the array of product of all rest elements
 *         except the elements in the given array. eg: [1,2,3] == [2*3,1*3,1*2]
 *         == [6,3,2]
 *
 */
public class ProductArrayProblem implements Problem, Serializable {

	int[] inputArr = { 2, 4, 1, 3, 5 };
	int size;

	@Override
	public void init(Object o) {

		System.out.println("Original: ");
		for (int i : inputArr) {
			System.out.print(i + "      ");
		}
		this.size = inputArr.length;
	}

	@Override
	public void solve() {
		multiply(inputArr, 1, 0);
	}

	private int multiply(int[] a, int fwdProduct, int indx) {
		int revProduct = 1;
		if (indx < this.size) {
			System.out.println("\n    Index:" + indx);
			revProduct = multiply(a, fwdProduct * a[indx], indx + 1);
			int cur = a[indx];
			a[indx] = fwdProduct * revProduct;
			System.out.println("fwdProduct: " + fwdProduct + "and revProduct: " + revProduct);

			revProduct *= cur;
		}
		return revProduct;
	}

	@Override
	public void printOutput() {
		System.out.println("\n\nProduct Array: ");
		for (int i : inputArr) {
			System.out.print(i + "      ");
		}
	}

}
