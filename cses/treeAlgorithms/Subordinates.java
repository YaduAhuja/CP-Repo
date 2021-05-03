/**
 *  Problem Link : https://cses.fi/problemset/task/1674/
 *  Runtime : 0.52s
 */

package cses.treeAlgorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Subordinates {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		ArrayList<ArrayList<Integer>> tree = new ArrayList<>(t+1);
		for(int i = 0; i < t+1; i++)tree.add(new ArrayList<>());
		int dist[] = new int[t+1];
		StringTokenizer st = new StringTokenizer(br.readLine().trim()," ");
		for(int i = 2; i < t+1; i++)tree.get(Integer.parseInt(st.nextToken())).add(i);
		br.close();
		System.out.println(mapdist(tree, dist));
	}

	private static String mapdist(ArrayList<ArrayList<Integer>> tree, int dist[]){
		dfsDown(tree, dist, 1);
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i < dist.length; i++)sb.append(dist[i]).append(" ");
		return sb.toString();
	}

	private static int dfsDown(ArrayList<ArrayList<Integer>> tree,int dist[], int element){
		ArrayList<Integer> child = tree.get(element);
		for(int i = 0; i < child.size(); i++)dist[element] += dfsDown(tree, dist, child.get(i));
		return dist[element]+1;
	}
}
