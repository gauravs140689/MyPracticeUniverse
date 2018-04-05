package com.practice.ds.array;

import com.practice.ds.array.Degree;
import com.practice.ds.array.Direction;
import com.practice.ds.array.Matrix;

public class MainClass {

	public static void main(String[] args) {
		// generateMatrix();
		rotateMatrix();

	}

	// Create Matrix of M*N
	public static void generateMatrix() {
		int row = 4;
		int col = 4;
		String[][] myMatrix = Matrix.createMatrix(row, col, "01,02,03,04,05,06,07,08,09,10,11,12,13,14,15,16");

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print("    " + myMatrix[i][j]);
			}
			System.out.println("");
		}
	}
	
	public static void rotateMatrix(){
		int row = 4;
		int col = 4;
		String[][] myMatrix = Matrix.createMatrix(row, col, "01,02,03,04,05,06,07,08,09,10,11,12,13,14,15,16");
		
		Direction direction = Direction.ANTICLOCKWISE;
		Degree degree =  Degree.NINTY;
		String[][] rotatedMatrix = Matrix.rotateMatrixWithExtraSpace(myMatrix,direction,degree);
		
		
		System.out.println("Original Matrix\n\n");
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				System.out.print("    " + myMatrix[i][j]);
			}
			System.out.println("");
		}
		System.out.println("\n\n----------------------------------------------------------");
		System.out.println("Matrix rotated "+direction+" with degree "+degree+"\n\n");
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				System.out.print("    " + rotatedMatrix[i][j]);
			}
			System.out.println("");
		}
	}

}
