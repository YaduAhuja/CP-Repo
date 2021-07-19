/**
 * Problem Link : https://codeforces.com/problemset/problem/1547/E
 * Runtime : 0.374s
 */
package codeForces.problemSet.rank1500;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class AirConditioners {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		var sb = new StringBuilder();
		for(int i = 0; i < t; i++) {
			br.readLine();
			int[] nAndk = nextIntArray(2, br);
			int[] airConditioners = nextIntArray(nAndk[1], br);
			int[] temps = nextIntArray(nAndk[1], br);
			sb.append(getLandTemps(nAndk[0], airConditioners, temps)).append('\n');
		}
		br.close();
		System.out.println(sb);
	}

	private static String getLandTemps(int N, int airConditioners[], int temps[]){
		long ret[] = new long[N];
		long left[] = new long[N];
		long right[] = new long[N];

		Arrays.fill(left, Integer.MAX_VALUE);
		Arrays.fill(right, Integer.MAX_VALUE);

		for(int i = 0; i < airConditioners.length; i++){
			left[airConditioners[i]-1] = temps[i];
			right[airConditioners[i]-1] = temps[i];
		}

		for(int i = 1; i < left.length; i++)
			left[i] = Math.min(left[i-1]+1, left[i]);

		for(int i = N-2; i >= 0; i--)
			right[i] = Math.min(right[i+1]+1, right[i]);
		
		for(int i = 0; i < ret.length; i++)
			ret[i] = Math.min(left[i], right[i]);

		StringBuilder sb = new StringBuilder();
		for(long i : ret) sb.append(i).append(" ");
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
