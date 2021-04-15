/**
 *  Problem Link : https://cses.fi/problemset/task/1636
 * 	Runtime : 0.34s
 */
package cses.dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CoinCombinations2 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		int coins[] = new int[Integer.parseInt(st.nextToken())];
		int sum = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine().trim()," ");
		for(int i = 0; i< coins.length; i++) coins[i] = Integer.parseInt(st.nextToken());
		br.close();

		System.out.println(getWays(coins, sum));
	}


	private static int getWays(int coins[], int sum){
		final int mod = (int)1e9+7;
		int dp[] = new int[sum+1];
		dp[0] = 1;
		for(int i = 0; i < coins.length; i++){ 
			for(int j = coins[i]; j < dp.length; j++){
				dp[j] = (dp[j]+ dp[j - coins[i]])%mod;
			}
		}
		return dp[sum];
	}
}
