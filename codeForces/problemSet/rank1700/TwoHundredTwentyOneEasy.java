/**
 *  Problem Link : https://codeforces.com/problemset/problem/1562/D1
 *  Runtime : 0.389s
 */

package codeForces.problemSet.rank1700;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TwoHundredTwentyOneEasy {
	private static int [] prefixSumOdd, prefixSumEven;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t =  Integer.parseInt(br.readLine().trim());
		var sb = new StringBuilder();
		while(t-- > 0){
			int input[] = nextIntArray(2, br);
			String s = br.readLine().trim();
			generatePrefixSum(s);
			for(int i = 0; i < input[1]; i++){
				int query[] = nextIntArray(2, br);
				sb.append(serveQuery(query[0], query[1])).append("\n");
			}
		}
		br.close();
		System.out.println(sb);
	}

	private static int serveQuery(int l, int r) {
		l--;
		if(l%2 == 0){
			if(Math.abs(prefixSumEven[r] - prefixSumEven[l]) == 0) 
				return 0;
		}
		if(l%2 == 1){
			if(Math.abs(prefixSumOdd[r] - prefixSumOdd[l]) == 0)
				return 0;
		}
		
		int diff = r - l;
		if(diff % 2 == 0) return 2;
		return 1;
	}

	private static void generatePrefixSum(String s){
		int sArr[] = new int[s.length()];
		
		for(int i = 0; i < sArr.length; i++) 
			if(s.charAt(i) == '+')
				sArr[i] = 1;
			else 
				sArr[i] = -1;
		
		prefixSumOdd = new int[s.length()+1];
		prefixSumEven = new int[s.length()+1];
		boolean add = true;

		for(int i = 0; i < s.length(); i++) {
			if(add) prefixSumEven[i+1] = prefixSumEven[i] + sArr[i];
			else prefixSumEven[i+1] = prefixSumEven[i] - sArr[i]; 
			add = !add;
		}
		add = true;
		for(int i = 1; i < s.length(); i++){
			if(add) prefixSumOdd[i+1] = prefixSumOdd[i] + sArr[i];
			else prefixSumOdd[i+1] = prefixSumOdd[i] - sArr[i];
			add = !add;
		}
	}

	private static int[] nextIntArray(int N, BufferedReader br) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine().trim()," ");
		int arr[] = new int[N];
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		return arr;
	}
}
