/**
 *  Problem Link : https://cses.fi/problemset/task/1158
 *  Runtime : 0.34s
 */
package cses.dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BookShop {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim()," ");
		int booksPrice[] = new int[Integer.parseInt(st.nextToken())];
		int pagesCount[] = new int[booksPrice.length];
		int max = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine().trim()," ");
		for(int i = 0; i < booksPrice.length; i++) booksPrice[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine().trim()," ");
		for(int i = 0; i < pagesCount.length; i++) pagesCount[i] = Integer.parseInt(st.nextToken());
		br.close();

		System.out.println(maxPages(booksPrice, pagesCount, max));
	}

	private static int maxPages(int booksPrice[], int pagesCount[], int max){
		int dp[] = new int[max+1];

		for(int i = 0; i < booksPrice.length; i++){
			for(int j = max; j >= booksPrice[i]; j-- ){
				dp[j] = Math.max(dp[j - booksPrice[i]]+ pagesCount[i], dp[j]);
			}
		}

		return dp[max];
	}	
}
