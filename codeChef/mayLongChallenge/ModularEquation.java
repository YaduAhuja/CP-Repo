/**
 *  Problem Link : https://www.codechef.com/MAY21B/problems/MODEQ
 * 	Runtime : 0.10s
 */
package codeChef.mayLongChallenge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ModularEquation {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            sb.append(getPairsCount(n, m)).append("\n");
        }
        br.close();
        System.out.print(sb);
    }

    private static long getPairsCount(int n, int m) {
        long count = 0;
        long arr[] = new long[n + 1];
        Arrays.fill(arr, 1);
        for (int i = 2; i <= n; i++) {
            int mod = m % i;
            count += arr[mod];
            for (int j = mod; j <= n; j += i) arr[j]++;
        }

        return count;
    }
}
