/**
 *  Problem Link : https://www.codechef.com/problems/DIWALI1
 *  Runtime : 0.24s
 */
package codeChef.practiceEasy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaximumLightUp {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int input1[] = nextIntArray(6, br);
            sb.append(getMaxTotal(input1)).append("\n");
        }
        br.close();
        System.out.println(sb);
    }

    private static long getMaxTotal(int input[]) {
        long ret = input[0];
        long item =
                Math.min(
                        input[2] * 1l + input[4] * 1l * input[1],
                        input[3] * 1l + input[5] * 1l * input[1]);
        return ret / item;
    }

    private static int[] nextIntArray(int N, BufferedReader br) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        return arr;
    }
}
