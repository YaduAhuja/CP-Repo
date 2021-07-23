/**
 * Problem Link : https://codeforces.com/contest/1530/problem/C
 * Runtime : 0.265s
 */
package codeForces.round733;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Pursuit {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < t; i++){
			int n = Integer.parseInt(br.readLine().trim());
			int myPoints[] = new int[n];
			int opsPoints[] = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine().trim()," ");
			for(int j = 0; j < myPoints.length; j++) myPoints[j] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine().trim()," ");

			for(int j = 0; j < myPoints.length; j++) opsPoints[j] = Integer.parseInt(st.nextToken());
			sb.append(getVal(myPoints, opsPoints)).append("\n");
		}
		br.close();
		System.out.println(sb);
	}

	private static int getVal(int myPoints[], int opsPoints[]){
		int ret = 1;
		Arrays.sort(myPoints);
		Arrays.sort(opsPoints);
		Deque<Integer> myDeque = new LinkedList<>();
		Deque<Integer> opsDeque = new LinkedList<>();

		int initialMatches = getMatchesCount(myPoints.length);
		// System.out.println("Initial Matches : "+ initialMatches);
		int sum1 = 0, sum2 = 0;
		int leftOps = myPoints.length - (initialMatches+1);
		for(int i = myPoints.length- initialMatches; i < myPoints.length; i++){
			sum1 += myPoints[i];
			sum2 += opsPoints[i];
			myDeque.addLast(myPoints[i]);
			opsDeque.addLast(opsPoints[i]);
		}
		
		for(; sum1 < sum2; ret++){
			int temp = getMatchesCount(myPoints.length+ret);
			if(temp - initialMatches > 0){
				//Grow the Deque
				sum1 += 100;
				myDeque.addLast(100);
				if(leftOps >= 0){
					sum2 += opsPoints[leftOps];
					opsDeque.addFirst(opsPoints[leftOps]);
					leftOps--;
				}else{
					opsDeque.addFirst(0);
				}
				initialMatches ++;
			}else{
				sum1 -= myDeque.removeFirst();
				sum1 += 100;
				myDeque.addLast(100);
			}
		}
		// System.out.println(myDeque + " Sum : "+ sum1);
		// System.out.println(opsDeque + " Sum : "+sum2);
		return --ret;
	}


	private static int getMatchesCount(int len){
		return len - (int) Math.floor(((double)len)/4);
	}
}
