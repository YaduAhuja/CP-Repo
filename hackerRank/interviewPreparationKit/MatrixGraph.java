package hackerRank.interviewPreparationKit;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class MatrixGraph{
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		int roads[][] = new int[Integer.parseInt(st.nextToken())-1][3];
		int machines[] = new int[Integer.parseInt(st.nextToken())];
		
		for(int i = 0; i < roads.length; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			roads[i][0] = Integer.parseInt(st.nextToken());
			roads[i][1] = Integer.parseInt(st.nextToken());
			roads[i][2] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < machines.length; i++) machines[i] = Integer.parseInt(br.readLine().trim());
		br.close();
		System.out.println(minTime(roads, machines));
	}
	
	static int minTime(int roads[][], int machines[]) {
		ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
		Set<Integer> st = new HashSet<>();
		
		for(int i = 0; i < machines.length; i++)st.add(machines[i]);
		
		boolean visited[] = new boolean[roads.length+1];
		
		for(int i = 0; i < roads.length+1; i++) graph.add(new ArrayList<>());
		
		for(int i = 0; i < roads.length; i++) {
			Edge e = new Edge(roads[i][0],roads[i][1], roads[i][2]);
			graph.get(roads[i][0]).add(e);
			graph.get(roads[i][1]).add(e);
		}
		
		int ret = 0;
		for(int i: machines) {
			if(visited[i]) continue;
			Set<Edge> edgeset = new HashSet<>(roads.length*2);
			PriorityQueue<Edge> pq = new PriorityQueue<>(roads.length*2, (e1,e2) -> e1.weight - e2.weight);
			
			Queue<Integer> q = new LinkedList<>();
			q.add(i);

			while(!q.isEmpty()) {
				int j = q.remove();
				
				if(visited[j])continue;
				visited[j] = true;
				
				if(st.contains(j))edgeset.addAll(graph.get(j));
				for(Edge e: graph.get(j)) {
					q.add(e.source);
					q.add(e.destination);
				}
			}
			
			pq.addAll(edgeset);
			
			while(pq.size() > 1) ret += pq.remove().weight;
			if(!pq.isEmpty()) {
				Edge e = pq.peek();
				if(st.contains(e.source) && st.contains(e.destination))ret+= e.weight;				
			}
		}
		
		return ret;
	}
	
	static class Edge{
		int source, destination, weight;
		Edge(int source, int destination, int weight){
			this.source = source;
			this.destination = destination;
			this.weight = weight;
		}
		
	}
}
