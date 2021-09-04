/**
 *  Problem Link : https://atcoder.jp/contests/abc217/tasks/abc217_c
 *  Runtime : 0.313s
 */

package atCoder.beginner217;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class InverseOfPermutation {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		int arr[] = nextIntArray(n, br);
		br.close();
		
		var sb = new StringBuilder();
		int ret[] = getArr(arr);
		for(int i : ret) 
			sb.append(i).append(" ");
		
		System.out.println(sb);
	}
	
	private static int[] getArr(int arr[]){
		int ret[] = new int[arr.length];
		for(int i = 0; i < arr.length; i++)
			ret[arr[i]-1] = i+1;
 
		return ret;
	}
 
	private static int[] nextIntArray(int N, BufferedReader br) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine().trim()," ");
		int arr[] = new int[N];
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		return arr;
	}
}
