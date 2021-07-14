/**
 * Problem Link : https://codeforces.com/problemset/problem/275/A
 */
package codeForces.problemSet.rank900;

import java.util.Scanner;

public class LightsOut {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int queries[][] = new int[3][3];
		
		for(int i = 0; i < queries.length; i++)
			for(int j = 0; j < queries[0].length; j++)
				queries[i][j] = sc.nextInt();
			
		sc.close();

		int matrix[][] = {{1,1,1},{1,1,1},{1,1,1}};

		for(int i = 0; i < queries.length; i++)
			for(int j = 0; j < queries[0].length; j++)
				if(queries[i][j]%2 != 0){
					flipSwitch(matrix, i, j);
					flipSwitch(matrix, i-1, j);
					flipSwitch(matrix, i+1, j);
					flipSwitch(matrix, i, j-1);
					flipSwitch(matrix, i, j+1);
				}

		for(int[] arr: matrix){
			for(int j : arr) System.out.print(j);
			System.out.println();
		}
	}


	private static void flipSwitch(int matrix[][], int i, int j){
		if(i < 0 || j < 0 || j >= matrix.length || i >= matrix.length) return;
		if(matrix[i][j] == 1) matrix[i][j] = 0;
		else matrix[i][j] = 1;			
	}
}
