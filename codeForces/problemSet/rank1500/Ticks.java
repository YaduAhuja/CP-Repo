/**
 *  Problem Link : https://codeforces.com/contest/1579/problem/C
 *  Runtime : 0.187s
 */
package codeForces.problemSet.rank1500;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ticks {
	private static boolean visited[][];

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		var sb = new StringBuilder();
		while (t-- > 0) {
			int[] input = nextIntArray(3, br);
			char matrix[][] = new char[input[0]][input[1]];
			for (int i = 0; i < matrix.length; i++)
				matrix[i] = br.readLine().trim().toCharArray();
			sb.append(isPossible(matrix, input[2])).append("\n");
		}
		br.close();
		System.out.println(sb);
	}

	private static String isPossible(char[][] matrix, int k) {
		visited = new boolean[matrix.length][matrix[0].length];
		for (int i = matrix.length - 1; i >= 0; i--) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] != '*')
					continue;
				int size = getTickSize(matrix, i, j);
				if (size >= k)
					color(i, j, size);
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == '*' && !visited[i][j])
					return "NO";
			}
		}
		return "YES";
	}

	private static void color(int i, int j, int size) {
		for (int ind = 0; ind <= size; ind++) {
			visited[i - ind][j + ind] = true;
			visited[i - ind][j - ind] = true;
		}
	}

	private static int getTickSize(char matrix[][], int i, int j) {
		int size = 0, ind = 1;
		// Check the Size of Tick
		while (getValue(matrix, i - ind, j + ind) == '*' && getValue(matrix, i - ind, j - ind) == '*') {
			size++;
			ind++;
		}
		return size;
	}

	private static char getValue(char matrix[][], int i, int j) {
		if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length)
			return '1';
		return matrix[i][j];
	}

	private static int[] nextIntArray(int N, BufferedReader br) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		int arr[] = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		return arr;
	}
}
