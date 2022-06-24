/**
 * Problem Link : https://codeforces.com/problemset/problem/1659/C
 * Runtime : 0.233s
 */

package codeForces.problemSet.rank1500;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LineEmpire {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			int NAB[] = nextIntArray(3, br);
			int arr[] = nextIntArray(NAB[0], br);
			sb.append(solveOptimized(arr, NAB[1], NAB[2])).append("\n");
		}
		br.close();
		System.out.println(sb);
	}

	private static long solve(int arr[], int A, int B) {
		long dp[] = new long[arr.length];
		int capital[] = new int[arr.length];
		Arrays.fill(dp, Long.MAX_VALUE);
		dp[0] = 0;
		capital[0] = 0;

		for (int i = 0; i < arr.length; i++) {
			if (i != 0) {
				capital[i] = capital[i - 1];
				dp[i] = dp[i - 1];
			}

			// When the cost of relocation is less than the cost of travel then relocate
			// cost of Relocation/Travel is dependent upon all the upcoming kingdoms
			long captureCost = getCaptureAndRelocationCost(arr[i], capital[i], A);
			long travelCost = getCaptureAndRelocationCost(arr[i], capital[i], B);
			int kingdomsLeft = arr.length - 1 - i;
			long cumulativeTravelCost = travelCost * kingdomsLeft;
			if (cumulativeTravelCost > captureCost) {
				capital[i] = arr[i];
				dp[i] += captureCost;
			}
			dp[i] += travelCost;
		}
		// For Decisions Made
		// System.out.println(Arrays.toString(capital));
		// System.out.println(Arrays.toString(dp));
		return dp[dp.length - 1];
	}

	private static long solveOptimized(int arr[], int A, int B) {
		// This is the memory optimized version of solve method
		long dp = 0;
		int capital = 0;

		for (int i = 0; i < arr.length; i++) {
			long captureCost = getCaptureAndRelocationCost(arr[i], capital, A);
			long travelCost = getCaptureAndRelocationCost(arr[i], capital, B);
			int kingdomsLeft = arr.length - 1 - i;
			long cumulativeTravelCost = travelCost * kingdomsLeft;
			if (cumulativeTravelCost > captureCost) {
				capital = arr[i];
				dp += captureCost;
			}
			dp += travelCost;
		}
		return dp;
	}

	private static long getCaptureAndRelocationCost(int cur, int capital, int A) {
		return 1l * (cur - capital) * A;
	}

	private static int[] nextIntArray(int N, BufferedReader br) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		int arr[] = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		return arr;
	}
}