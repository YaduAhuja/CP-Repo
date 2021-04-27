/**
 *  Problem Link : https://cses.fi/problemset/task/1633
 *  Runtime : 0.26s
 */
package cses.dynamicProgramming;

import java.util.Scanner;

public class DiceCombinations {
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        System.out.println(Combinations(n));
    }


    private static int Combinations(int n){
        long arr[] = new long[n+1];
        boolean dp[] = new boolean[n+1];
        arr[0] = 0;
        int mod = (int)1e9 +7;
        for(int i = 1; i <= 6 && i < arr.length; i++)arr[i] = 1;
        dp[0] = true;
        for(int i = 1; i < arr.length; i++){
            for(int j = 1; j<= 6; j++){
                if(j > i)break;
                arr[i] += arr[i-j];
                arr[i] %= mod;
            }
        }
        return (int)arr[n];
    }
}
