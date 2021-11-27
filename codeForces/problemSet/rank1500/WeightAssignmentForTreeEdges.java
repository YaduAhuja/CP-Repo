/**
 * Problem Link : https://codeforces.com/contest/1611/problem/D
 * Runtime : 0.265s
 */
package codeForces.problemSet.rank1500;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WeightAssignmentForTreeEdges {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		var sb = new StringBuilder();
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine().trim());
			int[] prev = nextIntArray(n, br);
			int[] perm = nextIntArray(n, br);
			sb.append(getTree(prev, perm)).append("\n");
		}
		br.close();
		System.out.println(sb);
	}

	private static String getTree(int[] prev, int[] perm) {
		boolean[] visited = new boolean[prev.length];
		int root = 0;
		for (int i = 0; i < prev.length; i++) {
			if (i == prev[i]) {
				root = i;
				break;
			}
		}

		if (perm[0] != root)
			return "-1";
		visited[root] = true;

		for (int i : perm) {
			if (!visited[prev[i]])
				return "-1";
			visited[i] = true;
		}

		int[] dist = new int[prev.length];

		for (int i = 0; i < perm.length; i++) {
			dist[perm[i]] = i;
		}

		int[] edge = new int[prev.length];
		for (int i = 0; i < prev.length; i++) {
			edge[i] = dist[i] - dist[prev[i]];
		}

		var sb = new StringBuilder();
		for (int i : edge)
			sb.append(i).append(" ");
		return sb.toString();
	}

	private static int[] nextIntArray(int N, BufferedReader br) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		int arr[] = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken()) - 1;
		return arr;
	}
}
