/**
 *  Problem Link : https://www.codechef.com/APRIL21B/problems/MEXSTR
 *  Runtime : 0.24s
 */

package codeChef.aprilLongChallenge;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BinaryStringMex {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine().trim());
		for(int i = 0; i < t; i++){
			char arr[] = br.readLine().trim().toCharArray();
			sb.append(getBinaryStringMex(arr)+"\n");
		}
		br.close();
		System.out.println(sb);
	}

	private static String getBinaryStringMex(char arr[]){
		boolean zero = false, one = false;
		int temp[] = new int[arr.length];
		int nextZero[] = new int[arr.length];
		int nextOne[] = new int[arr.length];
		int nextZ = Integer.MAX_VALUE, nextO = Integer.MAX_VALUE;
		for(int i = arr.length-1; i > -1; i--){
			nextOne[i] = nextO;
			nextZero[i] = nextZ;
			if(arr[i] == '1') nextO = i;
			else nextZ = i;
		}

		if(nextZ == Integer.MAX_VALUE) return "0";
		else if(nextO == Integer.MAX_VALUE) return "1";

		int count = 0;
		for(int i = arr.length-1; i > -1; i--){ 
			temp[i] = count;
			if(arr[i] == '1') one = true;
			else zero = true;
			if(one & zero) {
				count++;
				one = zero = false;
			}
		}

		StringBuilder sb = new StringBuilder("1");
		int ptr = nextO;
		while(true){
			nextO = nextOne[ptr]; nextZ = nextZero[ptr]; 
			if(nextO == Integer.MAX_VALUE || nextZ == Integer.MAX_VALUE){
				if(nextZ == Integer.MAX_VALUE)sb.append('0');
				else sb.append('1');
				break;
			}else{
				if(temp[nextZ] <= temp[nextO]){
					sb.append('0');
					ptr = nextZ;
				}else{
					sb.append('1');
					ptr = nextO;
				}
			}
		}

		return sb.toString();
	}
}
