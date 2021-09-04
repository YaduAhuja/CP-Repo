/**
 *  Problem Link : https://atcoder.jp/contests/abc217/tasks/abc217_d
 *  Runtime : 0.552s
 */

package atCoder.beginner217;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class CuttingWoods {
	private static TreeSet<Integer> logs = new TreeSet<>();
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input[] = nextIntArray(2, br);
		logs.add(0); logs.add(input[0]);
 
		var sb = new StringBuilder();
		for(int j = 0; j < input[1]; j++){
			int query[] = nextIntArray(2, br);
			sb.append(serveQuery(query));			
		}
		br.close();
		System.out.println(sb);
	}
	
	private static String serveQuery(int query[]){
		assert !logs.contains(query[1]);
		if(query[0] == 1){ // Cut The Log
			logs.add(query[1]);
			return "";
		}
		int ceil = logs.ceiling(query[1]);
		int floor = logs.floor(query[1]);
 
		return (ceil - floor)+"\n";
	}
 
	private static int[] nextIntArray(int N, BufferedReader br) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine().trim()," ");
		int arr[] = new int[N];
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		return arr;
	}
}
