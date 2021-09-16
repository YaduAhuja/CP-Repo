/**
 *  Problem Link : https://www.codechef.com/problems/FILLGRID
 *  Runtime : 0.13s
 */

package codeChef.practiceEasy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TheGridFillProblem {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		while(t-- > 0){
			int input = Integer.parseInt(br.readLine().trim());
			sb.append(getVal(input));
		}
		br.close();
		System.out.println(sb.toString());
	}

	private static String getVal(int input){
		if(input == 2) return "-1 -1\n-1 -1\n";
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < input; i++){
			for(int j = 0; j< input; j ++) {
				if(i == j) sb.append(-1);
				else sb.append(1);
				sb.append(" ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
