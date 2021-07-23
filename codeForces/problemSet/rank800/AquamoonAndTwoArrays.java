/**
 * Problem Link : https://codeforces.com/problemset/problem/1546/A
 * Runtime : 0.187s
 */
package codeForces.problemSet.rank800;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AquamoonAndTwoArrays {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			int first[] = nextIntArray(n, br);
			int second[] = nextIntArray(n, br);
			sb.append(getOperations(first, second)).append('\n');
		}
		br.close();
		System.out.println(sb);
	}


	private static String getOperations(int first[], int second[]){
		StringBuilder sb = new StringBuilder();
		int diff[] = new int[first.length];
		
		int canChange = 0;
		int maxChange = 0;

		for(int i = 0; i < diff.length; i++){
			diff[i] = first[i] - second[i];
			canChange += diff[i];
			maxChange += Math.abs(diff[i]);
		}

		if(canChange != 0) return "-1";

		sb.append(maxChange/2).append('\n');
		
		int left = 0;
		int right = 0;

		while(maxChange > 0){
			while(diff[left] <= 0) left++;
			while(diff[right] >= 0) right++;
			diff[left]--; diff[right]++;
			sb.append(left+1).append(" ").append(right+1).append('\n');
			maxChange -=2;
		}
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}


	private static int[] nextIntArray(int N, BufferedReader br) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine().trim()," ");
		int arr[] = new int[N];
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		return arr;
	}
}
