package codeChef.plagiarism;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Moss {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < t; i++){
			int n = Integer.parseInt(br.readLine().trim());
			int arr[] = nextIntArray(n, br);
			sb.append(getResult(arr)).append("\n");
		}
		br.close();
		System.out.println(sb);
	}

	private static String getResult(int arr[]){
		int max = Integer.MIN_VALUE;
		for(int i : arr){
			max = Math.max(max, i);
		}

		if(max >= 80) return "BANNED";
		if(max >= 60 && max < 80) return "PLAGIARISED -275";
		return "COINCIDENCE";
	}

	private static int[] nextIntArray(int N, BufferedReader br) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine().trim()," ");
		int arr[] = new int[N];
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		return arr;
	}
}
