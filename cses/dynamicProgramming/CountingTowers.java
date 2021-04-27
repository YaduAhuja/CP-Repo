/**
 *  Problem Link : https://cses.fi/problemset/task/2413
 *  Runtime : 0.19s
 */

package cses.dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CountingTowers {
	private static final int mod = (int)1e9+7;
	private static long dp[][];
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		int inp[] = new int[t];
		for(int i = 0; i < t; i++)inp[i] = Integer.parseInt(br.readLine().trim());
		br.close();
		System.out.println(solveQueries(inp));
	}

	private static String solveQueries(int arr[]){
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < arr.length; i++) max = Math.max(max, arr[i]);
		fillCountTowers(max);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < arr.length; i++)sb.append(dp[2][arr[i]]+"\n");
		return sb.toString();
	}

	private static void fillCountTowers(int n){
		dp = new long[3][n+1];

		// zeroth row is unlinked 
		// first row is linked
		// Second row is total of both upper rows
		dp[0][0] = 1; dp[1][0] = 0; dp[2][0] = 1;
		dp[0][1] = 1; dp[1][1] = 1;	dp[2][1] = 2;

		for(int i = 2; i < dp[0].length; i++){
			// if at i index we place a long bar of width 2
			dp[1][i] += dp[1][i-1]+ dp[0][i-1];// adding the unlinked and linked nodes of below
			dp[1][i] += dp[1][i-1];// extending the below 
			dp[1][i] %= mod;

			// if at i index we place blocks of width 1
			dp[0][i] += dp[0][i-1]+dp[1][i-1];
			dp[0][i] += dp[0][i-1]; //extending the below
			dp[0][i] += dp[0][i-1]*2;// fractional Extending
			dp[0][i] %= mod;

			dp[2][i] = (dp[1][i]+dp[0][i])%mod;
		}
	} 
}
