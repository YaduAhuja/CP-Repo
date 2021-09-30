
/**
 *  Problem Link : https://codeforces.com/problemset/problem/1574/C
 *  Runtime : 0.873s
 */

package codeForces.problemSet.rank1300;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class SlayTheDragon {
	private static TreeSet<Long> mapper;
	private static long sum = 0;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		long heroes[] = nextLongArray(n, br);
		preprocess(heroes);

		int dragonCount = Integer.parseInt(br.readLine().trim());
		var sb = new StringBuilder();
		for (int i = 0; i < dragonCount; i++) {
			long input[] = nextLongArray(2, br);
			sb.append(getMinValue(input[0], input[1])).append("\n");
		}
		br.close();
		System.out.println(sb);
	}

	private static long getMinValue(long defense, long attack) {
		long ret = Long.MAX_VALUE;
		if (mapper.ceiling(defense) != null)
			ret = Math.min(getValue(defense, attack, mapper.ceiling(defense)), ret);

		if (mapper.floor(defense) != null)
			ret = Math.min(getValue(defense, attack, mapper.floor(defense)), ret);
		return ret;
	}

	private static long getValue(long defense, long attack, long val) {
		long nearestDefense = sum - val;
		long ret = 0;

		if (val < defense)
			ret += defense - val;

		if (nearestDefense < attack)
			ret += attack - nearestDefense;

		return ret;
	}

	private static void preprocess(long heroes[]) {
		mapper = new TreeSet<>();
		for (long i : heroes) {
			mapper.add(i);
			sum += i;
		}
	}

	private static long[] nextLongArray(int N, BufferedReader br) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		long arr[] = new long[N];
		for (int i = 0; i < N; i++)
			arr[i] = Long.parseLong(st.nextToken());
		return arr;
	}
}
