package com.matrix;

public class RotateMatrix {

	public static void main(String[] args) {

		int[][] matrix = {{1,2}, {3,4}};
//		int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
//		int[][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
		
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();

		new RotateMatrixSolution().rotate(matrix);
		
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

}

class RotateMatrixSolution {
    public void rotate(int[][] matrix) {
        int x, y, temp;
        int i=0;
        int j=0;
        int newX = -1;
        int newY = -1;
        int size = matrix.length;

    	for(i=0; i<=(size - 1)/2; i++) {
        	for(j=i; j<size-1-i; j++) {
        		x = i;
        		y = j;
        		temp = matrix[x][y];

        		while(true) {
            		newX = size - 1 - y;
            		newY = x;
        			matrix[x][y] = matrix[newX][newY];

        			if(newX == i && newY == j) {
        				break;
        			}
        			x = newX;
        			y = newY;
        		}
    			matrix[x][y] = temp;
        	}
        }
    }
}