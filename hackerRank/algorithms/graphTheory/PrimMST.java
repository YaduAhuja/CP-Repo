package hackerRank.algorithms.graphTheory;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.PriorityQueue;

public class PrimMST {
	public static void main(String[] args) {
		int nodeCount = 5;
		List<List<Integer>> edges = new LinkedList<>();
		edges.add(Arrays.asList(1, 2, 3));
		edges.add(Arrays.asList(1, 3, 4));
		edges.add(Arrays.asList(4, 2, 6));
		edges.add(Arrays.asList(5, 2, 2));
		edges.add(Arrays.asList(2, 3, 5));
		edges.add(Arrays.asList(3, 5, 7));
		int startingNode = 1;
		System.out.println(prims(nodeCount, edges, startingNode));
	}

	private static int prims(int n, List<List<Integer>> edges, int start) {
		int cost = 0, visitedCount = 0;

		PriorityQueue<List<Integer>> pq = new PriorityQueue<>((l1,l2) -> l1.get(2) - l2.get(2));
		boolean visited[] = new boolean[n+1];
		visited[0] = true;		
		visited[start] = true;

		ListIterator<List<Integer>> ls = edges.listIterator();
		
		while(ls.hasNext()){
			List<Integer> temp = ls.next();
			if(temp.get(0) == start || temp.get(1) == start){
				pq.add(temp);
				ls.remove();
			}
		}
		visited[start] = true;
		
		while(!pq.isEmpty() && visitedCount < n){
			List<Integer> l = pq.remove();
			if(visited[l.get(0)] && visited[l.get(1)])continue;
			int node = 0;
			if(!visited[l.get(0)]) node = l.get(0);
			else node = l.get(1);
			cost += l.get(2);
			visitedCount++;

			ls = edges.listIterator();
			while(ls.hasNext()){
				List<Integer> temp = ls.next();
				if(temp.get(0) == node || temp.get(1) == node){
					pq.add(temp);
					ls.remove();
				}
			}
			visited[node] = true;
		}

		return cost;
	}
}
