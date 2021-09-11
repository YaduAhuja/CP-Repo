/**
 *  Problem Link : https://atcoder.jp/contests/abc218/tasks/abc218_e
 *  Runtime : 0.893s
 */

package atCoder.beginner218;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Destruction {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cons[] = nextIntArray(2, br);
		ArrayList<ArrayList<Edge>> graph = new ArrayList<>(cons[0]+5);
		for(int i = 0; i <= cons[0]; i++) graph.add(new ArrayList<>());
		for(int i = 0; i < cons[1]; i++){
			int input[] = nextIntArray(3, br);
			Edge adder = new Edge(input[0], input[1], input[2]);
 
			graph.get(input[0]).add(adder);
			graph.get(input[1]).add(adder);
		}
		br.close();
		System.out.println(getReward(graph));
	}
 
	private static long getReward(ArrayList<ArrayList<Edge>> graph) {
		boolean connected[] = new boolean[graph.size()];
		connected[1] = true;
		PriorityQueue<Edge> mapper = new PriorityQueue<>();
		HashSet<Edge> seen = new HashSet<>();
		long ret = 0;
		mapper.addAll(graph.get(1));
		while(!mapper.isEmpty()) {	
			Edge e = mapper.remove();
			if(seen.contains(e)) continue;
			seen.add(e);		
			if(connected[e.connection1] && connected[e.connection2]) {
				if(e.weight > 0) ret += e.weight;
				continue;
			}
 
			if(!connected[e.connection1]){
				mapper.addAll(graph.get(e.connection1));
				connected[e.connection1] = true;
			}
 
			if(!connected[e.connection2]){
				mapper.addAll(graph.get(e.connection2));
				connected[e.connection2] = true;
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
 
	private static class Edge implements Comparable<Edge> {
		int connection1, connection2, weight;
 
		Edge(int connection1, int connection2, int weight) {
			this.connection1 = connection1;
			this.connection2 = connection2;
			this.weight = weight;
		}
 
		@Override
		public int compareTo(Edge o) {
			return weight - o.weight;
		}
 
 
		public String toString() {
			return "("+connection1+", "+connection2+", "+ weight+")";
		}	
	}		
}
