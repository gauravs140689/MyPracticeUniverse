package com.practice.ds.array;

public class Matrix {

	/**
	 * creates matrix of r*c and values are populated row wise from left to right.
	 * values are comma separated in a string
	 * @param r
	 * @param c
	 * @param values
	 * @return Matrix in 2D String array
	 */
	public static String[][] createMatrix(int r, int c, String values) {
		String[][] matrix = new String[r][c];
		String[] values_array = values.split(",");

		for (int i = 0; i < values_array.length; i++) {
			matrix[i / c][i % c] = values_array[i];
		}

		return matrix;
	}

	/**
	 * It rotate given matrix in the give direction and degree. It uses extra temporary space of given matrix size 
	 * 
	 * @param originalMatrix
	 * @param direction
	 * @param degree
	 * @return return the resultant matrix in 2D String array
	 */
	public static String[][] rotateMatrixWithExtraSpace(final String[][] originalMatrix, Direction direction, Degree degree) {
		
		int row = originalMatrix.length;
		int col = originalMatrix[0].length;
		
		String[][] destMatrix =  new String[row][col];
		
		if (direction == Direction.CLOCKWISE) {
			if (degree == Degree.NINTY) {
				
				for(int i=0;i<row;i++){
					for(int j=0;j<col;j++){
						destMatrix[j][col-i-1] = originalMatrix[i][j];
					}
				}

			} else if (degree == Degree.ONEEIGHTY) {

			}
		} else if (direction == Direction.ANTICLOCKWISE) {
			if (degree == Degree.NINTY) {
				for(int i=0;i<row;i++){
					for(int j=0;j<col;j++){
						destMatrix[row-j-1][i] = originalMatrix[i][j];
					}
				}
			} else if (degree == Degree.ONEEIGHTY) {

			}
		}

		return destMatrix;
	}

}


