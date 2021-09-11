/**
 *  Problem Link : https://atcoder.jp/contests/abc218/tasks/abc218_f
 *  Runtime : 0.881s
 */
package atCoder.beginner218;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BlockedRoads {
	private static HashSet<Edge> minPath;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cons[] = nextIntArray(2, br);
		ArrayList<HashSet<Edge>> graph = new ArrayList<>();
		Edge [] edges = new Edge[cons[1]];

		for(int i = 0; i<= cons[0]; i++ ) graph.add(new HashSet<>());
		for(int i = 0; i < cons[1]; i++){
			int[] input = nextIntArray(2, br);
			Edge e = new Edge(input[0], input[1]);
			edges[i] = e;
			graph.get(input[0]).add(e);
		}

		br.close();
		System.out.println(getEdges(graph, edges, cons[0], cons[1]));
	}

	private static String getEdges(ArrayList<HashSet<Edge>> graph, Edge [] edges, int n, int m){
		var sb = new StringBuilder();
		int minPossiblePath = getMinPath(graph, true);
		// System.out.println(minPath);
		if(minPossiblePath == Integer.MAX_VALUE) {
			for(int i = 0; i < edges.length; i++) sb.append("-1\n");
		} else {
			for (Edge e : edges) {
				if(!minPath.contains(e)) {
					sb.append(minPossiblePath).append("\n");
				} else {
					graph.get(e.source).remove(e);
					int curMinPath = getMinPath(graph, false);
					graph.get(e.source).add(e);

					if(curMinPath == Integer.MAX_VALUE) sb.append("-1\n");
					else sb.append(curMinPath).append("\n");
				}
			}
		}

		return sb.toString();
	}

	private static int getMinPath(ArrayList<HashSet<Edge>> graph, boolean savePath) {
		boolean visited[] = new boolean[graph.size()];
		Edge path[] = new Edge[graph.size()];
		Queue<Edge> bfsQueue = new LinkedList<>();

		visited[1] = true;
		bfsQueue.addAll(graph.get(1));

		while(!bfsQueue.isEmpty() && !visited[graph.size()-1]){
			Edge e = bfsQueue.remove();
			if(visited[e.destination]) continue;
			visited[e.destination] = true;
			path[e.destination] = e;

			bfsQueue.addAll(graph.get(e.destination));
		}

		if(!visited[graph.size()-1]) return Integer.MAX_VALUE;

		return getPathLength(path, savePath);
	}

	private static int getPathLength(Edge path[], boolean savePath) {
		if(savePath) minPath = new HashSet<>();
		int ret = 0, cur = path.length-1;
		// System.out.println(Arrays.toString(path));
		while(cur != 1 && cur != 0) {
			if(savePath)
				minPath.add(path[cur]);
			cur = path[cur].source;
			ret++;
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

	private static class Edge {
		int source, destination;
		Edge(int source, int destination) {
			this.source = source;
			this.destination = destination;
		}

		@Override
		public String toString() {
			return "("+source+", "+destination+")";
		}
	}
}
