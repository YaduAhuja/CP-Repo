/**
 *  Problem Link : https://www.codechef.com/problems/BIGARRAY
 *  Runtime : 0.08s
 */
package codeChef.practiceEasy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ObtainTheSum {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            long input[] = nextIntArray(2, br);
            sb.append(getVal(input[0], input[1])).append("\n");
        }
        br.close();
        System.out.println(sb.toString());
    }

    private static long getVal(long n, long s) {
        long sum = (n * (n + 1)) / 2;
        sum -= s;
        return sum > 0 && sum <= n ? sum : -1;
    }

    private static long[] nextIntArray(int N, BufferedReader br) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
        long arr[] = new long[N];
        for (int i = 0; i < N; i++) arr[i] = Long.parseLong(st.nextToken());
        return arr;
    }
}
