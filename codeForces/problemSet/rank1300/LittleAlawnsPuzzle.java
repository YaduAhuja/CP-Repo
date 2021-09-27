/**
 *  Problem Link : https://codeforces.com/problemset/problem/1534/C
 *  Runtime : 0.919s
 */
package codeForces.problemSet.rank1300;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class LittleAlawnsPuzzle {
	private static boolean[] visited;
	private static final int MOD = (int) 1e9+7;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		var sb = new StringBuilder();
		
		while(t-- > 0) {
			int n = Integer.parseInt(br.readLine().trim());
			int[] input1 = nextIntArray(n, br);
			int[] input2 = nextIntArray(n, br);
			sb.append(getResult(input1, input2)).append("\n");
		}
		br.close();
		System.out.println(sb);
	}
 
	private static void dfs(ArrayList<ArrayList<Integer>> adj, int cur, int par) {
		if(visited[cur]) return;
		visited[cur] = true;
		
		for(int i : adj.get(cur)){
			if(i == par) continue;
			dfs(adj, i, cur);
		}
	}
 
	private static long getResult(int[] input1, int[] input2){
		long ret = 1;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>(input1.length+1);
		visited = new boolean[input1.length+1];
 
		for(int i = 0; i <= input1.length; i++) adj.add(new ArrayList<>());
		for(int i = 0; i < input1.length; i++) {
			adj.get(input1[i]).add(input2[i]);
			adj.get(input2[i]).add(input1[i]);
		}
 
		for(int i = 0; i < input1.length; i++){
			if(!visited[input1[i]]) {
				ret = ret*2 % MOD;
				dfs(adj, input1[i], 0);
			}
		}
 
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
