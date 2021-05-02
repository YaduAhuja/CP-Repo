/**
 *  Problem Link : https://www.codechef.com/problems/ARRROT
 *  Runtime : 0.22s
 */

package codeChef.practiceEasy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ArrayRotation {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int arr[] = new int[Integer.parseInt(br.readLine().trim())];
		StringTokenizer st = new StringTokenizer(br.readLine().trim()," ");
		for(int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		int queriesCount = Integer.parseInt(br.readLine().trim());
		br.close();
		System.out.println(getSum(arr, queriesCount));
	}

	private static String getSum(int arr[], int queriesCount){
		final long MOD = (int)1e9+7;
		long sum = 0;
		for(int i = 0; i < arr.length; i++)sum += arr[i];
		sum %= MOD;
		if(sum < 0)sum += MOD;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < queriesCount; i++){
			sum += sum;
			if(sum >= MOD)sum -= MOD;
			sb.append(sum).append("\n");	
		}
		return sb.toString();
	}
}
