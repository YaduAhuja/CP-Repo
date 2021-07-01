package codeForces.round65;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ProgressBar {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		var sb = new StringBuilder();
		var st = new StringTokenizer(br.readLine().trim()," ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		sb.append(getProgress(n, k, t));

		br.close();
		System.out.println(sb);
	}

	private static String getProgress(int n, int k, int t){
		int arr[] = new int[n];
		int sum = (int)(((double)n*k*t) / 100 );
		// System.out.println(sum);
		int count = 0;
		for(int i = 0; i < arr.length && count <= sum; i++){
			arr[i] = Math.min(sum - count, k);
			count += arr[i];
		}

		StringBuilder sb = new StringBuilder();
		for(int i : arr){
			sb.append(i).append(" ");
		}
		return sb.toString();
	}
}
