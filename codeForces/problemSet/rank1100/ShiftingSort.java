/**
 *  Problem Link : https://codeforces.com/contest/1579/problem/B
 *  Runtime : 0.233s
 */
package codeForces.problemSet.rank1100;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class ShiftingSort {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		var sb = new StringBuilder();
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine().trim());
			int[] arr = nextIntArray(n, br);
			sb.append(getSteps(arr));
		}
		br.close();
		System.out.println(sb);
	}

	private static String getSteps(int[] arr) {
		List<String> operations = new ArrayList<>();
		int[] dummy = Arrays.copyOf(arr, arr.length);
		Arrays.sort(dummy);
		for (int i = 0; i < arr.length; i++) {
			int d = findIndex(arr, dummy[i], i);
			if (d == i)
				continue;
			d -= i;
			shift(arr, i, d);
			operations.add((i + 1) + " " + arr.length + " " + d);
		}

		var sb = new StringBuilder();
		sb.append(operations.size()).append("\n");
		for (String s : operations)
			sb.append(s).append("\n");
		return sb.toString();
	}

	private static int findIndex(int[] arr, int element, int left) {
		for (int i = left; i < arr.length; i++)
			if (arr[i] == element)
				return i;
		return Integer.MAX_VALUE;
	}

	private static void shift(int[] arr, int l, int d) {
		// Dummy Array
		int temp[] = new int[arr.length - l];
		for (int i = l; i < arr.length; i++) {
			if (i - d < l)
				temp[temp.length + i - l - d] = arr[i];
			else
				temp[i - l - d] = arr[i];
		}

		for (int i = 0; i < temp.length; i++)
			arr[l + i] = temp[i];
	}

	private static int[] nextIntArray(int N, BufferedReader br) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		int arr[] = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		return arr;
	}
}
