package hackerRank.algorithms.graphTheory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KruskalMST {
	static class Edge{
		int source, dest, weight;
		Edge(int source, int dest, int weight){
			this.source = source;
			this.dest = dest;
			this.weight = weight;
		}
	}

	static class Dsj{
		Dsj parent = this;
		int rank = 0;
		Dsj(){}
		Dsj findParent(){
			if(parent != this) parent = parent.findParent();
			return parent;
		}
		
		void merge(Dsj other){
			parent = this.findParent();
			other.parent = other.findParent();
			other.parent.parent = this.parent;
			other.rank = this.rank+1;
		}
	}

	public static void main(String[] args) {
		// 2 Sample Test Cases
		// int gNodes = 4;
		// List<Integer> gFrom = new ArrayList<>(Arrays.asList(1, 1, 4, 2, 3, 3));
		// List<Integer> gTo = new ArrayList<>(Arrays.asList(2, 3, 1, 4, 2, 4));
		// List<Integer> gWeight = new ArrayList<>(Arrays.asList(5, 3, 6, 7, 4, 5));
		
		int gNodes = 5;
		List<Integer> gFrom = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 2, 3, 4));
		List<Integer> gTo = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 3, 4, 5));
		List<Integer> gWeight = new ArrayList<>(Arrays.asList(20, 50, 70, 90, 30, 40, 60));
		
		System.out.println(kruskals(gNodes, gFrom, gTo, gWeight));
	}

	private static int kruskals(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight){
		Dsj Nodes[] = new Dsj[gNodes+1];
		for(int i = 0; i < Nodes.length; i++)Nodes[i] = new Dsj();

		Edge edges[] = new Edge[gFrom.size()];
		for(int i = 0; i < gFrom.size(); i++) edges[i] = new Edge(gFrom.get(i), gTo.get(i), gWeight.get(i));

		Arrays.sort(edges, (e1,e2) -> e1.weight - e2.weight);

		int cost = 0;
		int connected = 0;
		
		for(int i = 0; i < edges.length && connected < gNodes; i++){
			Dsj root = Nodes[edges[i].source].findParent();
			Dsj oRoot = Nodes[edges[i].dest].findParent();

			if(root != oRoot){
				Nodes[edges[i].source].merge(Nodes[edges[i].dest]);
				cost += edges[i].weight;
				connected++;
			}
		}

		return cost;
	}
}
