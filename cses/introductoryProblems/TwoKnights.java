/**
 *  Problem Link : https://cses.fi/problemset/task/1072/
 *  Runtime : 0.23s
 */

package cses.introductoryProblems;

import java.util.Scanner;

public class TwoKnights {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		System.out.print(getValues(n));
	}

	private static String getValues(int n) {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) sb.append(solve(i) + "\n");
		return sb.toString();
	}

	private static long solve(int n) {
		// Explicit Formula 0.5 n^4 - 4.5 n^2 + 12n - 8
		return (long)((Math.pow(n, 4) / 2 + 12 * n) - (4.5 * Math.pow(n, 2) + 8));
	}
}
