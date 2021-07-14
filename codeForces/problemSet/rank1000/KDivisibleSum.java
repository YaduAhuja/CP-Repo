/**
 * Problem Link : https://codeforces.com/problemset/problem/1476/A
 */
package codeForces.problemSet.rank1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class KDivisibleSum {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            sb.append(getMaxElement(n, k)).append('\n');
        }
        br.close();
        System.out.print(sb);
    }

    private static int getMaxElement(int n, int k) {
        long x = n;
        long y = k;
        long cf = (n + k - 1) / k;
        y *= cf;
        return (int) ((x + y - 1) / x);
    }
}
