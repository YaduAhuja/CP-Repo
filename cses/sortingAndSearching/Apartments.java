/**
 *  Problem Link : https://cses.fi/problemset/task/1084/
 *  Runtime : 0.91s
 */

package cses.sortingAndSearching;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Apartments{	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine().trim()," ");
		ArrayList<Integer> apartments = new ArrayList<>(m);
		ArrayList<Integer> customers = new ArrayList<>(n);
		for(int i = 0; i < n; i++)customers.add(Integer.parseInt(st.nextToken()));
		st = new StringTokenizer(br.readLine().trim()," ");
		for(int i = 0; i < m; i++) apartments.add(Integer.parseInt(st.nextToken()));
		br.close();
		System.out.println(getApplicants(apartments, customers, k));
	}

	private static int getApplicants(ArrayList<Integer> apartments, ArrayList<Integer> customers, int k){
		Collections.sort(apartments);
		Collections.sort(customers);
		int count = 0;
		
		for(int cptr = 0, aptr = 0; aptr < apartments.size() && cptr < customers.size();){
			if(apartments.get(aptr) <= customers.get(cptr)+k && apartments.get(aptr) >= customers.get(cptr)-k){
				aptr++;
				cptr++;
				count++;
			}else if(customers.get(cptr) < apartments.get(aptr)- k)cptr++;
			else aptr++;
		}

		return count;
	}
}
