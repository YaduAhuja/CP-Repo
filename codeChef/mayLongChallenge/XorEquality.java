/**
 *  Problem Link : https://www.codechef.com/MAY21B/problems/XOREQUAL
 *	Runtime : 0.20s
 */
package codeChef.mayLongChallenge;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class XorEquality {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        int max = Integer.MIN_VALUE;
        int queries[] = new int[t];
        for (int i = 0; i < t; i++) {
            queries[i] = Integer.parseInt(br.readLine().trim());
            max = Math.max(max, queries[i]);
        }
        int arr[] = new int[max];
        countXor(arr);
        System.out.print(serveQueries(queries, arr));
    }

    private static String serveQueries(int queries[], int arr[]) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < queries.length; i++) {
            sb.append(arr[queries[i] - 1]).append("\n");
        }
        return sb.toString();
    }

    private static void countXor(int arr[]) {
        final int mod = (int) 1e9 + 7;
        arr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            long x = arr[i - 1];
            arr[i] = (int) ((x * 2) % mod);
        }
    }
}
