/**
 *  Problem Link : https://codeforces.com/problemset/problem/1561/C
 *  Runtime : 0.249s
 */
package codeForces.problemSet.rank1300;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DeepDownBelow {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		var sb = new StringBuilder();
		for(int i = 0; i < t; i++) {
			int caves = Integer.parseInt(br.readLine().trim());
			int arr[][] = new int[caves][];
			for(int x = 0; x< caves; x++) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim()," ");
				arr[x] = new int[Integer.parseInt(st.nextToken())];
				for(int j = 0; j < arr[x].length; j++) 
					arr[x][j] = Integer.parseInt(st.nextToken());
			}
			sb.append(solveCaves(arr)).append("\n");
 		}
		br.close();
		System.out.println(sb);
	}

	private static long solveCaves(int arr[][]){
		long ret = 0;
		Cave[] caveArr = new Cave[arr.length];
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[i].length; j++)
				arr[i][j] -= j;

			caveArr[i] = new Cave(i, getMax(arr[i]), arr[i].length);
		}
		
		Arrays.sort(caveArr);
		int gains[] = new int[caveArr.length];
		int ks = 0;
		int itr = 0;
		for(Cave c : caveArr){
			gains[itr++] = c.entrance - ks;
			ks += c.gain;
		}
		ret = getMax(gains)+1;
		return ret;
	}

	private static int getMax(int ...arr) {
		int ret = Integer.MIN_VALUE;
		for(int i : arr)
			ret = Math.max(ret,i);
		return ret;
	}
	
	private static class Cave implements Comparable<Cave>{
		int id,entrance, gain;

		Cave(int id, int entrance, int gain) {
			this.id = id;
			this.entrance = entrance;
			this.gain = gain;
		}

		@Override 
		public String toString(){
			return "("+id+", "+entrance+", "+gain+")";
		}

		@Override
		public int compareTo(Cave other){
			if(entrance == other.entrance)
				return other.gain - this.gain;
			return entrance - other.entrance;
		}
	}
}
