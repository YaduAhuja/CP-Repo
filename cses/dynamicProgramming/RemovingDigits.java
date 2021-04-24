/**
 *  Problem Link : https://cses.fi/problemset/task/1637
 *  Runtime : 0.17s
 */

package cses.dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class RemovingDigits {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int inp = sc.nextInt();
		sc.close();
		System.out.println(getSteps(inp));
	
	}

	private static int getSteps(int n){
		int dp[] = new int[n+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for(int i = 1; i < Math.min(dp.length, 10); i++) dp[i] = 1;
		
		for(int i = 10; i < dp.length; i++)fetchOrSave(i,dp);
		// System.out.println(Arrays.toString(dp));
		return dp[n];
	}


	private static void fetchOrSave(int i, int dp[]){
		int copy = i;
		int min = Integer.MAX_VALUE;
		while(copy > 0){
			int diff = copy % 10;
			copy /= 10;
			if(diff != 0)min = Math.min(dp[i-diff]+1,min);
		}

		dp[i] = min;
	}
}
