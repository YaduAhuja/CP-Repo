/**
 * Problem Link : https://codeforces.com/problemset/problem/1538/G
 * Runtime : 0.278s
 */
package codeForces.problemSet.rank2100;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GiftSet {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < t; i++){
			int[] inp = nextIntArray(4, br);
			sb.append(maxSets(inp)).append("\n");
		}
		br.close();
		System.out.println(sb);
	}

	private static int maxSets(int[] inp){
		long left = 0, right = Math.max(inp[0], inp[1]);
		if(inp[2] == inp[3]) {
			return Math.min(inp[0], inp[1])/inp[2];
		}

		if(inp[2] < inp[3]) swap(inp);

		int x = inp[0], y = inp[1], a = inp[2], b = inp[3];
		
		while(right-left > 1){
			long mid = (left + right)/2;
			long r = (long) Math.floor((x - b*mid) * 1.0 /(a-b));
			long l = (long) Math.ceil((y - a*mid) * 1.0 /(b-a));
			
			if(Math.max(l, 0) <= Math.min(r, mid))
				left = mid;
			else
				right = mid;
		}

		return (int)left;
	}

	private static void swap(int inp[]){
		int temp = inp[3];
		inp[3] = inp[2];
		inp[2] = temp;
 	}
	
	 private static int[] nextIntArray(int N, BufferedReader br) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine().trim()," ");
		int arr[] = new int[N];
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		return arr;
	}
}
