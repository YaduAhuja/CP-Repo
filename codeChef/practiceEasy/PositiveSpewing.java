/**
 *  Problem Link : https://www.codechef.com/problems/POSSPEW
 *  Runtime : 0.99s
 */
package codeChef.practiceEasy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class PositiveSpewing {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			int[] input = nextIntArray(2, br);
			int[] arr = nextIntArray(input[0], br);
			sb.append(getVal(arr, input[1])).append("\n");
		}
		br.close();
		System.out.println(sb.toString());
	}

	private static long getVal(int arr[], int k) throws Exception {
		long ret = 0;
		HashSet<Integer> oneIndex = new HashSet<>(arr.length);
		for (int i = 0; i < arr.length; i++) {
			ret += arr[i];
			if (arr[i] > 0)
				oneIndex.add(i);
		}
		int i = 0;
		for (; i < k && oneIndex.size() < arr.length; i++) {
			ret += 2l * oneIndex.size();
			ArrayList<Integer> cur = new ArrayList<>();
			//Adding Neighbours
			for (int j : oneIndex) {
			    if(j == arr.length-1) cur.add(0);
				else cur.add(j+1);
				if(j == 0) j = arr.length-1;
				else j--;
				cur.add(j);
			}
			oneIndex.addAll(cur);
		}
		if (i < k){
			long temp = 2l * (k - i) * oneIndex.size();
			ret += temp;
		}
		return ret;
	}

	private static int[] nextIntArray(int N, BufferedReader br) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		int arr[] = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		return arr;
	}
}
