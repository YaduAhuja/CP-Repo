package codeForces.round733;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BinaryDecimals{
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		var sb = new StringBuilder();
		for(int i = 0; i < t; i++){
			String s = br.readLine().trim();
			sb.append(getBinaryDecimal(s)).append("\n");
		}
		br.close();
		System.out.println(sb);
	}


	private static int getBinaryDecimal(String s){
		int max = Integer.MIN_VALUE;

		for(int i = 0; i < s.length(); i++){
			max = Math.max(max,Integer.parseInt(s.substring(i,i+1)));
		}

		return max;
	}
}