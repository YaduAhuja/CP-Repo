package hackerRank.dataStructures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

public class SuperMaximumCostQueries{
	static class Split implements Comparable<Split>{
		int start;
		long val;
		Split(int start){
			this.start = start;
		}
		Split(int start,long val){
			this.start = start;
			this.val = val;
		}
		
		public int compareTo(Split o) {
			return this.start - o.start;
		}
		
		public String toString() {
			return start+"="+val;
		}
	}
	static class Pair{
		int val;
		HashSet<Integer> indexer;
		Pair(int val){
			this.val = val;
			indexer = new HashSet<>();
		}
		
		public String toString() {
			return indexer.toString();
		}
	}
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int inp[] = Stream.of(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		int[][] tree = new int[inp[0]-1][];
		int queries[][] = new int[inp[1]][];
		
		for(int i = 0; i < inp[0]-1; i++)
			tree[i] = Stream.of(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
		
//		for(int arr[]: tree)System.out.println(Arrays.toString(arr));
		
		
		
		for(int i = 0; i < queries.length; i++)
			queries[i] = Stream.of(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		br.close();
		
		long ret[] = solve(tree,queries);
	
		for(long i: ret)System.out.println(i);
	}
	
	
	private static long[] solve(int [][] tree, int [][] queries) {
		ArrayList<Pair> graph = new ArrayList<>();
		Map<Integer, Long> finMap = new LinkedHashMap<>(tree.length); 
		long ret[] = new long[queries.length];
		
		for(int i = 0; i < tree.length+1; i++) {
			graph.add(new Pair(0));
			graph.get(i).indexer.add(i);
		}
		
		Arrays.sort(tree, (o1,o2) -> o1[2] - o2[2]);
		
		for(int i = 0; i < tree.length; i++) {
			Pair smallPair = graph.get(tree[i][0]-1);
			Pair largePair = graph.get(tree[i][1]-1);
			
			if(smallPair.indexer.size() > largePair.indexer.size()) {
				Pair temp = smallPair;
				smallPair = largePair;
				largePair = temp;
			}
			long n = ((long)smallPair.indexer.size()* (smallPair.indexer.size()-1))/2;
			n += ((long)largePair.indexer.size()* (largePair.indexer.size()-1))/2;
			
			largePair.val = Math.max(largePair.val,Math.max(smallPair.val, tree[i][2]));
			
			for(int j: smallPair.indexer) {
				largePair.indexer.add(j);
				graph.set(j, largePair);
			}
			
			long m = ((long)largePair.indexer.size()* (largePair.indexer.size()-1))/2;
	
			finMap.put(largePair.val, finMap.getOrDefault(largePair.val, 0l)+ m-n);
		}
		// System.out.println(finMap);
		ArrayList<Split> finList = new ArrayList<>(finMap.size());
		finList.add(new Split(0, 0));
		int iter = 0;
		for(int i : finMap.keySet()) {
			finList.add(new Split(i,finList.get(iter).val+finMap.get(i)));
			iter++;
		}

		for(int i = 0; i < queries.length; i++) {
			ret[i] = calculateCost(finList,queries[i][0], queries[i][1]); 
		}
		
		return ret;
	}
	
	private static long calculateCost(ArrayList<Split> finList, int l, int r) {
		long left = 0, right = 0;
		if(finList.get(finList.size()-1).start  < r)right = finList.get(finList.size()-1).val;
		if(finList.get(finList.size()-1).start  < l)left = finList.get(finList.size()-1).val;
		
		// System.out.println(left +"   "+right);

		if(l < finList.get(finList.size()-1).start) {
			int n = Collections.binarySearch(finList, new Split(l));
			if(n < 0) n = Math.abs(n)- 2;
			else n--;
			if(n < 0) n = 0;
			
			// System.out.println(n);
			left = finList.get(n).val;
		}
		
		if(r <= finList.get(finList.size()-1).start) {
			int n = Collections.binarySearch(finList, new Split(r));
			if(n < 0) n = Math.abs(n)-2;

			if(n < 0) n = 0;
			// System.out.println(n);
			right = finList.get(n).val;
		}
		
		
		return right - left;
	}
}
