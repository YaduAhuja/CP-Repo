/**
 *  Problem Link : https://cses.fi/problemset/task/1639
 *  Runtime : 0.30s
 */

package cses.dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EditDistance {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine().trim();
		String x = br.readLine().trim();
		br.close();
		System.out.println(getEditDistance(s,x));
	}

	private static int getEditDistance(String s, String x){
		int dp[][] = new int[s.length()+1][x.length()+1];
		for(int i = 1; i < dp[0].length; i++)dp[0][i] = i;
		for(int i = 1; i < dp.length; i++)dp[i][0] = i;
		
		for(int i = 1; i < dp.length; i++){
			for(int j = 1; j < dp[0].length; j++){
				if(s.charAt(i-1) == x.charAt(j-1))dp[i][j] = dp[i-1][j-1];
				else{
					dp[i][j] = 1+ Math.min(dp[i-1][j],Math.min(dp[i-1][j-1], dp[i][j-1]));
				}
			}
		}
		return dp[dp.length-1][dp[0].length-1];
	}

}
