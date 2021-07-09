package codeChef.julyLongChallenge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class KPathQuery{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		for(int i = 0; i < t; i++){
			int n = Integer.parseInt(br.readLine().trim());
			ArrayList<ArrayList<Integer>> graph = new ArrayList<>(n+1);
			for(int j = -1; j < n; j++) graph.add(new ArrayList<>());

			for(int j = 1; j < n; j++){
				StringTokenizer st = new StringTokenizer(br.readLine().trim()," ");
				int source = Integer.parseInt(st.nextToken());
				int dest = Integer.parseInt(st.nextToken());
				
				graph.get(source).add(dest);
				graph.get(dest).add(source);
			}

			int q = Integer.parseInt(br.readLine().trim());
			for(int j = 0; j < q; j++){
				StringTokenizer st = new StringTokenizer(br.readLine().trim()," ");
				int query[] = new int[Integer.parseInt(st.nextToken())];
				
			}
		}
		br.close();
	}
}