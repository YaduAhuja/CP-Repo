/**
 *  Problem Link : https://cses.fi/problemset/task/1646
 *  Runtime : 0.65s
 */

package cses.rangeQueries;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StaticRangeSumQueries {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim()," ");
		long arr[] = new long[Integer.parseInt(st.nextToken())+1];
		int queriesCount = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine().trim()," ");
		for(int i = 1; i < arr.length; i++) arr[i] = Integer.parseInt(st.nextToken()) + arr[i-1];

		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < queriesCount; i++){
			st = new StringTokenizer(br.readLine().trim()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(ServeQueries(arr, a, b)).append("\n");
		}
		
		br.close();
		System.out.println(sb);
	}

	private static String ServeQueries(long arr[], int a, int b){
		return Long.toString(arr[b] - arr[--a]);
	}
}
