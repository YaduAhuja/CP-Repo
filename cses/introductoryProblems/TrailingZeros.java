/**
 *  Problem Link : https://cses.fi/problemset/task/1618/
 *  Runtime : 0.13s
 */
package cses.introductoryProblems;

import java.util.Scanner;

public class TrailingZeros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        System.out.println(countTrailingZeros(n));
    }

    private static int countTrailingZeros(int n) {
        int sum = 0;
        for (int divisor = 5; divisor <= n; divisor *= 5) sum += n / divisor;
        return sum;
    }
}
