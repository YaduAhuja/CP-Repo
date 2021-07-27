/**
 * Problem Link : https://codeforces.com/contest/1553/problem/A
 * Runtime : 0.187s
 */
package codeForces.harbourSpace;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DigitsSum{
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i < t; i++){
			sb.append(getInterestingNumber(Integer.parseInt(br.readLine().trim()))).append('\n');
		}
		br.close();
		System.out.println(sb);
	}

	private static int getInterestingNumber(int n){
		int ret = 0;
		if(n%10 == 9) ret++;
		ret += n/10;
		return ret;
	}
}