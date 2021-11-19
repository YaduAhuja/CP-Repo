
/**
 *  Problem Link : https://www.codechef.com/problems/BININV
 *  Runtime : 0.30s
 */
package codeChef.practiceEasy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BinaryInversion {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			int[] cons = nextIntArray(2, br);
			Pair[] arr = new Pair[cons[0]];
			for (int i = 0; i < arr.length; i++)
				arr[i] = new Pair(br.readLine().trim());

			sb.append(getMinInversions(arr)).append("\n");
		}
		br.close();
		System.out.println(sb);
	}

	private static long getMinInversions(Pair[] arr) {
		for (Pair p : arr)
			p.oneCount = getOneCount(p.s);

		Arrays.sort(arr);

		long ret = 0;
		int zeroCount = 0;
		for (int i = arr.length - 1; i > -1; i--) {
			Pair temp = arr[i];
			for (int j = temp.s.length() - 1; j > -1; j--)
				if (temp.s.charAt(j) == '0')
					zeroCount++;
				else
					ret += zeroCount;
		}

		return ret;
	}

	private static int getOneCount(String s) {
		int ret = 0;
		for (char c : s.toCharArray())
			if (c == '1')
				ret++;

		return ret;
	}

	private static int[] nextIntArray(int N, BufferedReader br) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		int arr[] = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		return arr;
	}

	private static class Pair implements Comparable<Pair> {
		String s;
		int oneCount;

		Pair(String s) {
			this.s = s;
			this.oneCount = -1;
		}

		@Override
		public int compareTo(Pair o) {
			return oneCount - o.oneCount;
		}

		@Override
		public String toString() {
			return s;
		}
	}
}
