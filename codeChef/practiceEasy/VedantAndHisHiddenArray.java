/**
 * Problem Link : https://www.codechef.com/problems/SUMPARITY
 * Runtime : 0.16s
 */
package codeChef.practiceEasy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class VedantAndHisHiddenArray {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int inp[] = nextIntArray(2, br);
            sb.append(solve(inp[0], inp[1])).append("\n");
        }
        br.close();
        System.out.println(sb);
    }

    private static String solve(int n, int and) {
        if (n == 1) {
            if (and % 2 == 0) return "Even";
            return "Odd";
        }
        if (and % 2 == 0) // Checking if And of whole array is odd or even
        return "Impossible";
        if (n % 2 == 0) return "Even";
        return "Odd";
    }

    private static int[] nextIntArray(int N, BufferedReader br) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        return arr;
    }
}
