/**
 *  Problem Link : https://www.codechef.com/problems/SWAPGAME
 *  Runtime : 0.29s
 */
package codeChef.practiceEasy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MakeThatArray {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();

		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine().trim());
			int[] A = nextIntArray(n, br);
			int[] B = nextIntArray(n, br);
			sb.append(getValue(A, B)).append("\n");
		}
		br.close();
		System.out.println(sb);
	}

	private static long getValue(int[] A, int[] B) {
		long valA = 0, valB = 0;

		for (int i = 0; i < A.length; i++)
			valA += A[i] * 1l * (i + 1);

		for (int i = 0; i < B.length; i++)
			valB += B[i] * 1l * (i + 1);

		return valB - valA;
	}

	private static int[] nextIntArray(int N, BufferedReader br) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		int arr[] = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		return arr;
	}
}
