/**
 * Problem Link : https://www.codechef.com/problems/ALLDIV3
 * Runtime : 0.24s
 */
package codeChef.practiceEasy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MakeItDivisible {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			int N = Integer.parseInt(br.readLine().trim());
			int[] arr = nextIntArray(N, br);
			sb.append(getOps(arr)).append("\n");
		}
		br.close();
		System.out.println(sb);
	}

	private static int getOps(int[] arr) {
		for (int i = 0; i < arr.length; i++)
			arr[i] = arr[i] % 3;
		int one = 0, two = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 1)
				one++;
			else if (arr[i] == 2)
				two++;
		}

		int ret = Math.min(one, two);
		int rem = one + two - 2 * ret;
		if (rem % 3 == 0)
			return ret + (rem / 3) * 2;
		return -1;
	}

	private static int[] nextIntArray(int N, BufferedReader br) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		int arr[] = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		return arr;
	}
}
