package hackerRank.interviewPreparationKit;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Matrix{
	static class Node{
		int dist = 0;
		int index = 0;
		Node parent = this;
		boolean isMachine = false;
		Node(int i ){
			this.index = i;
		}

		Node findRoot(){ // Lazy Propagation 
			if(parent != this) parent = parent.findRoot();
			return parent;
		}
	}

	private static int minTime(List<List<Integer>> roads, List<Integer> machines){
		Collections.sort(roads, (i,j) -> j.get(2) - i.get(2));

		Node graph[] = new Node[roads.size()+1];
		for(int i = 0; i < graph.length; i++) graph[i] = new Node(i);
		for(int i : machines) graph[i].isMachine = true;
		int cost = 0;
		for(List<Integer> road: roads){
			graph[road.get(0)].findRoot();
			graph[road.get(1)].findRoot();
			if(graph[road.get(0)].parent.isMachine && graph[road.get(1)].parent.isMachine){
				cost += road.get(2);
			}else{
				if(graph[road.get(1)].parent.isMachine) graph[road.get(0)].parent.isMachine = true;
				graph[road.get(1)].parent = graph[road.get(0)].parent;	
			}
		}
		return cost;
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim()," ");
		int nodeCount = Integer.parseInt(st.nextToken());
		int machineCount = Integer.parseInt(st.nextToken());
		List<List<Integer>> roads = new ArrayList<>(nodeCount-1);
		List<Integer> machines = new ArrayList<>(machineCount);
		for(int i = 0; i < nodeCount-1; i++){
			st = new StringTokenizer(br.readLine().trim()," ");
			int src = Integer.parseInt(st.nextToken());
			int dest = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			roads.add(Arrays.asList(src,dest,weight));
		}
		
		for(int i = 0; i < machineCount; i++)machines.add(Integer.parseInt(br.readLine().trim()));
		br.close();
		System.out.println(minTime(roads, machines));
	}
}