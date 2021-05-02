package codeChef.practiceBeginner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ChefOnIsland{
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < t; i++){
			StringTokenizer st = new StringTokenizer(br.readLine().trim()," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int xr = Integer.parseInt(st.nextToken());
			int yr = Integer.parseInt(st.nextToken());
			int days = Integer.parseInt(st.nextToken());
			sb.append(willSurvive(x, y, xr, yr, days)+"\n");
		}
		br.close();
		System.out.println(sb);
	}

	private static String willSurvive(int x, int y, int xr, int yr, int days){
		return Math.min((float)x/xr, (float)y/yr) >= days ? "YES":"NO";
	}
}