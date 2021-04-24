/**
 *  Problem Link : https://cses.fi/problemset/task/1157/
 *  Runtime : 0.08s
 */

package cses.additionalProblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NumberGrid {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim()," ");
		br.close();
		System.out.println(getNumber(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
	}

	private static int getNumber(int x, int y){
		return (x-1)^(y-1);
	} 
}
