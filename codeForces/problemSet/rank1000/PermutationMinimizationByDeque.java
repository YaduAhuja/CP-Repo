/**
 *  Problem Link : https://codeforces.com/contest/1579/problem/E1 
 *  Runtime : 0.342s
 */
package codeForces.problemSet.rank1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class PermutationMinimizationByDeque {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		var sb = new StringBuilder();
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine().trim());
			int arr[] = nextIntArray(n, br);
			sb.append(getMinPermutation(arr)).append("\n");
		}
		br.close();
		System.out.println(sb);
	}

	private static String getMinPermutation(int arr[]) {
		var sb = new StringBuilder();
		Deque<Integer> dq = new LinkedList<>();
		dq.add(arr[0]);

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < dq.peekFirst())
				dq.addFirst(arr[i]);
			else
				dq.add(arr[i]);
		}

		while (!dq.isEmpty())
			sb.append(dq.removeFirst()).append(" ");
		return sb.toString();
	}

	private static int[] nextIntArray(int N, BufferedReader br) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		int arr[] = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		return arr;
	}
}
