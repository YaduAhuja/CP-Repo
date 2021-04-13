package hackerRank.interviewPreparationKit;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class RoadsAndLibraries {
	static long ret;
	static boolean visited[];
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		long ret[] = new long[t];
		
		for(int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int n = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			int c_lib = Integer.parseInt(st.nextToken());
			int c_road = Integer.parseInt(st.nextToken());
			int cities[][] = new int[size][2];
			for(int j = 0; j < size; j++) {
				st = new StringTokenizer(br.readLine()," ");
				cities[j][0] = Integer.parseInt(st.nextToken());
				cities[j][1] = Integer.parseInt(st.nextToken());
			}
			ret[i] = roadsAndLibraries(n, c_lib, c_road, cities);
		}
		br.close();
		
		for(long i:ret)System.out.println(i);
	}
	
	static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
//		System.out.println(n +"    "+ c_lib+"     "+c_road);
		if(c_lib <= c_road) return (long)n * (long)c_lib;
		ret = 0;
		
		ArrayList<HashSet<Integer>> adj = new ArrayList<>(n);
		for(int i = 0; i < n; i++) adj.add(new HashSet<>());
		for(int i = 0; i < cities.length; i++) {
			adj.get(cities[i][0]-1).add(cities[i][1]-1);
			adj.get(cities[i][1]-1).add(cities[i][0]-1);
		}
		visited = new boolean[n];
		for(int i = 0; i < visited.length; i++) {
			if(!visited[i]) {
				dfs(adj, i, c_lib, c_road, true);
			}
		}
		
		return ret;
    }
	
	static void dfs(ArrayList<HashSet<Integer>> adj,int n,int c_lib,int c_road,boolean Lib) {
		if(visited[n] == true) return;
		visited[n] = true;
		if(Lib) ret += c_lib;
		else ret += c_road;
		for(Integer i: adj.get(n)) {
			dfs(adj,i,c_lib,c_road,false);
		}
	}
}
