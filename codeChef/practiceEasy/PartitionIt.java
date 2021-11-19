
/**
 *  Problem Link : https://www.codechef.com/problems/PARPERM
 *  Runtime : 0.24s
 */

package codeChef.practiceEasy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PartitionIt {
	private static boolean isPrime[] = new boolean[(int) 1e5 + 10];

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		Arrays.fill(isPrime, true);
		sieve();
		while (t-- > 0) {
			int[] cons = nextIntArray(2, br);
			sb.append(solve(cons)).append("\n");
		}

		br.close();
		System.out.println(sb);
	}

	private static StringBuilder solve(int[] cons) {
		ArrayList<Integer> less = new ArrayList<>();
		ArrayList<Integer> more = new ArrayList<>();
		more.add(1);

		for (int i = 2; i <= cons[0]; i++) {
			if (isPrime[i] && i * 2 > cons[0])
				more.add(i);
			else
				less.add(i);
		}

		StringBuilder sb = new StringBuilder();

		if (cons[1] >= less.size()) {
			sb.append("YES\n");

			for (int i = 0; i < more.size() && cons[1] > less.size(); i++)
				less.add(more.get(i));

			for (int i : less)
				sb.append(i).append(" ");

		} else if (cons[1] <= more.size()) {
			sb.append("YES\n");

			while (cons[1] < more.size())
				more.remove(more.size() - 1);

			for (int i : more)
				sb.append(i).append(" ");
		} else
			sb.append("NO");

		return sb;
	}

	private static void sieve() {
		for (int i = 2; 1l * i * i < isPrime.length; i++)
			if (isPrime[i])
				for (int j = i * i; j < isPrime.length; j += i)
					isPrime[j] = false;
	}

	private static int[] nextIntArray(int N, BufferedReader br) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		int arr[] = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		return arr;
	}
}
