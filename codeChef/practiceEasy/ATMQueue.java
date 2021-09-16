/**
 *  Problem Link : https://www.codechef.com/problems/ATMQ
 *  Runtime : 0.47s
 */

package codeChef.practiceEasy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ATMQueue {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		while(t-- > 0){
			int n = Integer.parseInt(br.readLine().trim());
			Person [] arr = nextPersonArray(n, br);
			getValues(arr);
			sb.append(printArr(arr)).append("\n");
		}
		br.close();
		System.out.println(sb);
	}

	private static void getValues(Person [] arr){
		int time = 1;
		PriorityQueue<Person> pq = new PriorityQueue<>();
		pq.add(arr[0]);
		for(int i = 1; i < arr.length;){
			pq.remove().passout = time;
			for(; i <= 2*time && i < arr.length; i++) pq.add(arr[i]);
			time++;
		}

		while(!pq.isEmpty()) pq.remove().passout = time++;
	}

	private static String printArr(Person [] arr){
		StringBuilder sb = new StringBuilder();
		for(Person i : arr) sb.append(i.passout).append(" ");
		return sb.toString();
	}

	private static Person[] nextPersonArray(int N, BufferedReader br) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine().trim()," ");
		Person arr[] = new Person[N];
		for(int i = 0; i < N; i++)
			arr[i] = new Person(i+1,Integer.parseInt(st.nextToken()));
		return arr;
	}

	private static class Person implements Comparable<Person> {
		int id, power, passout;
		Person(int id, int power){
			this.id = id;
			this.power = power;
		}

		@Override
		public int compareTo(Person o){
			if(power == o.power) return id - o.id;
			return o.power - power;
		}
	}
}
