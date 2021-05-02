/**
 *  Problem Link : https://cses.fi/problemset/task/1754
 *  Runtime : 0.33s
 */
package cses.introductoryProblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CoinPiles {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < t; i++){
			StringTokenizer st = new StringTokenizer(br.readLine().trim()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(canRemove(a, b)).append("\n");
		}	
		br.close();
		System.out.println(sb);
	}

	private static String canRemove(int a, int b){
		if(2*a - b >= 0 && 2*b - a >= 0 && (2*b - a )%3 == 0 && (2*a - b) %3 == 0) return "YES";
		return "NO";
	}
}
