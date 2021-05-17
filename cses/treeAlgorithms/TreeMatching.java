package cses.treeAlgorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TreeMatching {
	private static boolean visited[];

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>(n+1);
		for(int i = 0; i < n+1; i++)graph.add(new ArrayList<>());

		for(int i = 1; i < n; i++){
			StringTokenizer st  = new StringTokenizer(br.readLine().trim(), " ");
			int source = Integer.parseInt(st.nextToken());
			int dest = Integer.parseInt(st.nextToken());
			graph.get(source).add(dest);
			graph.get(dest).add(source);
		}
		visited = new boolean[n+1];
		br.close();
		System.out.println(getMatchingPairCount(graph));
	}

	private static int getMatchingPairCount(ArrayList<ArrayList<Integer>> graph){
		int dist[] = new int[graph.size()];	
		Arrays.fill(dist, -1);
		for(int i= 0; i < graph.size(); i++){
			if(graph.get(i).size() == 1){
				dist[i] = 0;
				visited[i] = true;
			}
		}
		// System.out.println(Arrays.toString(dist));
		return getCountForSubtree(graph, dist, 1, -1);
	}

	private static int getCountForSubtree(ArrayList<ArrayList<Integer>> graph, int dist[], int node, int prev){
		if(graph.get(node).size() == 1) return 0;
		if(visited[node]) return dist[node];
		int ret = 0;
		boolean nullFlag = false;
		for(int i : graph.get(node)){
			if(i == prev)continue;
			int val = getCountForSubtree(graph, dist, i, node);
			if(val == 0) nullFlag = true;
			else ret += val;
		}

		if(nullFlag) return ret+1;
		return ret;
	}
}
