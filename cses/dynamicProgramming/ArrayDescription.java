/**
 *  Problem Link : https://cses.fi/problemset/task/1746/
 *  Runtime : 0.45s
 */

package cses.dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ArrayDescription {

	private static final int mod = (int)1e9+7;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim()," ");
		int arr[] = new int[Integer.parseInt(st.nextToken())];
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine().trim()," ");
		for(int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(st.nextToken());
		br.close();
		System.out.println(getNumArr(arr,m));
	}

	private static int getNumArr(int arr[], int m){
		int dp[][] = new int[arr.length][m+1];
		if(arr[0] == 0)for(int i = 1; i < dp[0].length; i++)dp[0][i] = 1;
		else dp[0][arr[0]] = 1;
	
		for(int i = 1; i < dp.length; i++){
			if(arr[i] != 0){
				dp[i][arr[i]] = (dp[i][arr[i]] + fetchNumFromArr(dp, i-1, arr[i]-1))%mod;
				dp[i][arr[i]] = (dp[i][arr[i]] + fetchNumFromArr(dp, i-1, arr[i]))%mod;
				dp[i][arr[i]] = (dp[i][arr[i]] + fetchNumFromArr(dp, i-1, arr[i]+1))%mod;
			}else{
				for(int j = 1; j < dp[0].length; j++){
					dp[i][j] = (dp[i][j]+fetchNumFromArr(dp, i-1, j-1))%mod;
					dp[i][j] = (dp[i][j]+fetchNumFromArr(dp, i-1, j))%mod;
					dp[i][j] = (dp[i][j]+fetchNumFromArr(dp, i-1, j+1))%mod;
				}
			}
		}

		if(arr[arr.length-1] != 0) return dp[dp.length-1][arr[arr.length-1]];
		int sum = 0;
		for(int i = 0; i < dp[0].length; i++)sum = (sum + dp[dp.length-1][i])%mod;
		return sum;
	}


	private static int fetchNumFromArr(int dp[][], int i, int j){
		if(i < dp.length && j < dp[0].length) return dp[i][j];
		return 0;
	}
}
