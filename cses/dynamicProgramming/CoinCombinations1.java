/**
 *  Problem Link : https://cses.fi/problemset/task/1635/
 * 	Runtime : 0.36s
 */

package cses.dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CoinCombinations1{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim()," ");
		int coins[] = new int[Integer.parseInt(st.nextToken())];
		int sum = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine().trim()," ");
		for(int i = 0; i < coins.length; i++) coins[i]  = Integer.parseInt(st.nextToken());
		br.close();

		System.out.println(getWays(coins, sum));
	}


	private static int getWays(int coins[], int sum){
		long mod = (long)1e9 + 7;

		long dp[] = new long[sum+1];
		dp[0] = 1;
		for(int i = 0; i < dp.length; i++){
			for(int j = 0; j < coins.length; j++){
				if(i - coins[j] > -1){
					dp[i] += dp[i - coins[j]];
				}
			}
			if(dp[i] > mod)dp[i] %= mod;
		}

		return (int)(dp[sum]%mod);
	}
}