/**
 * Problem Link : https://codeforces.com/contest/1611/problem/A
 * Runtime : 0.187s
 */
package codeForces.problemSet.rank800;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MakeEven {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		var sb = new StringBuilder();
		while (t-- > 0) {
			String s = br.readLine().trim();
			sb.append(getOps(s)).append("\n");
		}
		br.close();
		System.out.println(sb);
	}

	private static int getOps(String s) {
		if (Integer.parseInt(s) % 2 == 0)
			return 0;

		for (int i = 0; i < s.length(); i++) {
			int num = Integer.parseInt(s.charAt(i) + "");
			if (num % 2 == 0) {
				if (i == 0)
					return 1;
				return 2;
			}
		}

		return -1;
	}
}
