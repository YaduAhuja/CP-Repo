/**
 * Problem Link : https://codeforces.com/contest/1549/problem/A 
 * Runtime: 0.233s
 */
package codeForces.round736;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class GregorAndCryptography {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		var sb = new StringBuilder();
		for(int i = 0; i < t; i++) {
			int x = Integer.parseInt(br.readLine().trim());
			sb.append(getPrimes(x)).append("\n");
		}
		br.close();
		System.out.println(sb);
	}



	private static String getPrimes(int x){
		String ret = "";
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i = 2; i < x; i++){
			if(map.containsKey(x%i)){
				ret = map.get(x%i)+" "+i;
				break;
			}else{
				map.put(x%i, i);
			}
		}
		return ret;
	}
}
