package hackerRank.dataStructures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Stream;

public class ComponentGraph {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine().trim());
		ArrayList<HashSet<Integer>> graph = new ArrayList<>();
		
		for(int i = 0; i < 2*n; i++)graph.add(new HashSet<>(Arrays.asList(i)));		
		
		for(int i = 0; i < n ; i++) {
			int inp[] = Stream.of(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();			
			updateGraph(graph, inp);
		}
		br.close();
		
		System.out.println(getMinMax(graph));
	}
	
	private static String getMinMax(ArrayList<HashSet<Integer>> graph) {
		HashSet<Integer> smallSet = graph.get(0);
		HashSet<Integer> largeSet = graph.get(0);
		
		for(int i = 1; i < graph.size(); i++) {
			HashSet<Integer> temp = graph.get(i);
			if(smallSet.size() == 1) smallSet = temp;
			if(smallSet.size() > temp.size() && temp.size() > 1) smallSet = temp;
			if(temp.size() > largeSet.size()) largeSet = temp;
		}
		
		return smallSet.size()+" "+ largeSet.size();
	}
	
	private static void updateGraph(ArrayList<HashSet<Integer>> graph, int[] query) {
		HashSet<Integer> smallSet = graph.get(query[0]-1);
		HashSet<Integer> largeSet = graph.get(query[1]-1);
		
		if(smallSet == largeSet) return;
		
		if(smallSet.size() > largeSet.size()) {
			HashSet<Integer> temp = largeSet;
			largeSet = smallSet;
			smallSet = temp;
		}
		
		
		for(int i: smallSet) {
			largeSet.add(i);
			graph.set(i, largeSet);
		}
	}
}
