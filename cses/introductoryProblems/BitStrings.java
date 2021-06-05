/**
 *  Problem Link : https://cses.fi/problemset/task/1617
 *  Runtime : 0.14s
 */
package cses.introductoryProblems;

import java.util.Scanner;

public class BitStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        System.out.println(getCombinations(n));
    }

    private static int getCombinations(int n) {
        if (n < 1) return 0;
        final int MOD = (int) 1e9 + 7;
        int ret = 1;
        for (int i = 0; i < n; i++) ret = (ret << 1) % MOD;
        return ret;
    }
}
