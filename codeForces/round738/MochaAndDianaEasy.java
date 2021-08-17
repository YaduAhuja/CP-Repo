/**
 *  Problem Link : https://codeforces.com/contest/1559/problem/D1
 *  Runtime : 0.187s
 * 
 *  Difference Between Hard and Easy Version is of Constraints
 */

package codeForces.round738;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MochaAndDianaEasy {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		var st = new StringTokenizer(br.readLine().trim()," ");
		int n = Integer.parseInt(st.nextToken());	
		int m = Integer.parseInt(st.nextToken());	
		int d = Integer.parseInt(st.nextToken());
		
		List<Node> mochaForest = new ArrayList<>(n+1);
		List<Node> dianaForest = new ArrayList<>(n+1);
		
		for(int i = 0; i <= n; i++){
			mochaForest.add(new Node(i));
			dianaForest.add(new Node(i));
		}
		
		//Generating Forests for Mocha & Diana
		for(int i = 0; i < m+d; i++){
			st = new StringTokenizer(br.readLine().trim()," ");
			int source = Integer.parseInt(st.nextToken());
			int destination = Integer.parseInt(st.nextToken());
			if(i < m) mochaForest.get(source).merge(mochaForest.get(destination));
			else dianaForest.get(source).merge(dianaForest.get(destination));
		}
		br.close();
		
		var sb = new StringBuilder();
		List<Integer[]> edges = getValidEdges(mochaForest, dianaForest);
		
		sb.append(edges.size()).append("\n");
		for(Integer arr[]: edges) 
			sb.append(arr[0]).append(" ").append(arr[1]).append("\n");

		System.out.println(sb);
	}
	
	private static List<Integer[]> getValidEdges(List<Node> mochaForest, List<Node> dianaForest) {
		List<Integer[]> ret = new ArrayList<>();

		for(int i = 1; i < mochaForest.size()-1; i++){
			for(int j = i+1; j < mochaForest.size(); j++){
				if(canMerge(mochaForest.get(i), mochaForest.get(j)) && canMerge(dianaForest.get(i), dianaForest.get(j))){
					ret.add(new Integer[] {mochaForest.get(i).id, mochaForest.get(j).id});
					mochaForest.get(i).merge(mochaForest.get(j));
					dianaForest.get(i).merge(dianaForest.get(j));
				}
			}
		}
		return ret;
	}

	private static boolean canMerge(Node t1, Node t2){
		t1.findParent();
		t2.findParent();
		if(t1.parent == t2.parent) return false;
		return true;
	}

	private static class Node{
		int id,rank = 0;
		Node parent = this;
		Node(int id){
			this.id = id;
		}

		private void merge(Node other){
			Node curParent = findParent();
			Node otherParent = other.findParent();

			//Union By Rank
			if(curParent.rank < otherParent.rank){
				curParent.parent = otherParent;
			}else{
				if(curParent.rank == otherParent.rank) 
					curParent.rank++;
				otherParent.parent = curParent;
			}
		}

		private Node findParent(){
			if(parent == this) return this;
			
			//Path Compression
			parent = parent.findParent();
			return parent;
		}

		public String toString(){
			return "["+id+", "+rank+"]";
		}
	}
}
