/**
 *  Problem Link : https://www.codechef.com/problems/BENCHP
 *  Runtime : 0.36s
 */

package codeChef.practiceEasy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BenchPress {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < t; i++){
			StringTokenizer st = new StringTokenizer(br.readLine().trim()," ");
			int n = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int wr = Integer.parseInt(st.nextToken());
			
			int arr[] = new int[n];
			st = new StringTokenizer(br.readLine().trim()," ");
			for(int j = 0; j < n; j++) arr[j] = Integer.parseInt(st.nextToken());
			sb.append(satisfied(arr, w, wr)).append("\n");
		}
		br.close();
		System.out.println(sb);
	}
	
	private static String satisfied(int arr[], int w, int wr){
		if(wr >= w) return "YES";
		Arrays.sort(arr);
		for(int i = 1; i < arr.length; i+=2){
			if(arr[i-1] == arr[i]) wr+= 2*arr[i];
			if(wr >= w) return "YES";
		}
		return "NO";
	}
}
