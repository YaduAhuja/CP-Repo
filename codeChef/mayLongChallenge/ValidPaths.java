/**
 *  Problem Link : https://www.codechef.com/MAY21B/problems/VPATH
 *  Runtime : 1.15s
 */

package codeChef.mayLongChallenge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ValidPaths {
	private static final int mod = (int)1e9+7;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < t; i++){
			int n = Integer.parseInt(br.readLine().trim());
			Node[] graph = new Node[n+1];
			for(int j = 0; j < graph.length; j++) graph[j] = new Node(j);
			for(int j = 2; j < graph.length; j++){
				StringTokenizer st = new StringTokenizer(br.readLine().trim()," ");
				int source = Integer.parseInt(st.nextToken());
				int dest = Integer.parseInt(st.nextToken());

				graph[source].children.add(graph[dest]);
				graph[dest].children.add(graph[source]);
			}

			sb.append(getSum(graph)).append("\n");
		}
		br.close();
		System.out.println(sb);
	}

	private static int getSum(Node graph[]){
		dfs(graph[1], graph[1]);
		return (int)graph[1].treeWeight;
	}

	private static void dfs(Node cur, Node prev) {
		int sum = 0;
		for(Node i : cur.children){
			if(i == prev) continue;
			dfs(i, cur);
			cur.nodeWeight += 2* i.nodeWeight;
			cur.nodeWeight %= mod;
			cur.treeWeight += i.nodeWeight;
			cur.treeWeight += i.treeWeight;
			cur.nodeWeight %= mod;
			sum += i.nodeWeight;
		}
		
		for(Node i : cur.children){
			if(i == prev)continue;
			cur.treeWeight += i.nodeWeight * (sum - i.nodeWeight);
			cur.treeWeight %= mod;
		}
	}

	private static class Node{
		int id;
		long nodeWeight,treeWeight;
		List<Node> children;

		Node(int id){
			this.id = id;
			this.nodeWeight = this.treeWeight = 1;
			this.children = new ArrayList<>();
		}

		public String toString(){
			return this.id+"";
		}
	}
}
