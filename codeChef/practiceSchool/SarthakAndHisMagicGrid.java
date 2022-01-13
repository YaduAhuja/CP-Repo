
/**
 * Problem Link : https://www.codechef.com/EXUN21B/problems/GRIDXOR
 * Runtime : 0.11s
 */
package codeChef.practiceSchool;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SarthakAndHisMagicGrid {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine().trim());
			sb.append(solve(n)).append("\n");
		}
		br.close();
		System.out.print(sb);
	}

	private static String solve(int n) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				sb.append("1 ");
			sb.append("\n");
		}
		return sb.toString();
	}
}