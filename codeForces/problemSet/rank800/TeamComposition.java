/**
 * Problem Link : https://codeforces.com/contest/1611/problem/B
 * Runtime : 0.186s
 */

package codeForces.problemSet.rank800;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TeamComposition {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		var sb = new StringBuilder();
		while (t-- > 0) {
			long[] arr = nextLongArray(2, br);
			sb.append(getTeams(arr[0], arr[1])).append("\n");
		}
		br.close();
		System.out.println(sb);
	}

	private static long getTeams(long a, long b) {
		long min = Math.min(a, b);
		min = Math.min(min, (a + b) / 4);
		return min;
	}

	private static long[] nextLongArray(int N, BufferedReader br) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		long arr[] = new long[N];
		for (int i = 0; i < N; i++)
			arr[i] = Long.parseLong(st.nextToken());
		return arr;
	}
}