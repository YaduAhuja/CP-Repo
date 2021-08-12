/**
 * Problem Link : https://www.codechef.com/COOK131B/problems/CHFPLN 
 * Runtime: 0.31s
 */

package codeChef.julyCookOff;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ChefInInfinitePlane {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < t; i++){
			int n = Integer.parseInt(br.readLine().trim());
			int arr[] = nextIntArray(n, br);
			sb.append(getDistinctElem(arr)).append("\n");
		}
		br.close();
		System.out.println(sb);
	}

	private static int getDistinctElem(int arr[]){
		int ret = 0;
		int nums[] = new int[200001];
		for(int i : arr){
			if(nums[i] < i-1){
				ret++;
				nums[i]++;
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
}
