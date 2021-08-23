/**
 *  Problem Link : https://codeforces.com/problemset/problem/1560/D
 *  Runtime : 0.327s
 */
package codeForces.problemSet.rank1300;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MakeAPowerOf2 {
	private static ArrayList<Long> powersOf2;
	
	public static void main(String args[]) throws Exception {
		preprocess();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		var sb = new StringBuilder();
		while(t-- > 0){
			int q = Integer.parseInt(br.readLine().trim());
			sb.append(getMinEditDist(q)).append("\n");
		}
		br.close();
		System.out.println(sb);
	}

	private static int getMinEditDist(int q){
		int ret = Integer.MAX_VALUE;
		for(long i : powersOf2)
			ret = Math.min(getEditDist(q, i), ret);
		
		return ret;
	}

	private static int getEditDist(int q, long t){
		int left = 0, right = 0;
		char arr[] = Integer.toString(q).toCharArray();
		char temp[] = Long.toString(t).toCharArray();
		
		for(; left < arr.length && right < temp.length; left++){
			if(arr[left] == temp[right]) right++;
		}

		return (arr.length-left)+(left-right) + (temp.length-right);
	}

	private static void preprocess(){
		powersOf2 = new ArrayList<>();
		long power = 1;
		while(power > 0){
			powersOf2.add(power);
			power <<=1;
		}
	}
}
