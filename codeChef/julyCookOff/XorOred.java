/**
 * Problem Link : https://www.codechef.com/COOK131B/problems/XORORED
 * Runtime: 0.19s
 */
package codeChef.julyCookOff;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class XorOred {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < t; i++){
			int n = Integer.parseInt(br.readLine().trim());
			int arr[] = nextIntArray(n, br);
			sb.append(getMinXorAndX(arr)).append("\n");
		}
		br.close();
		System.out.println(sb);
	}

	private static String getMinXorAndX(int arr[]){
		int and = -1;
		for(int i: arr) and &= i;
		int or = 0;
		for(int i : arr) or |= (i^and);
		return and +" "+ or;
	}

	private static int[] nextIntArray(int N, BufferedReader br) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine().trim()," ");
		int arr[] = new int[N];
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		return arr;
	}
}
