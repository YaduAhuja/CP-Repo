/**
 *  Problem Link : https://codeforces.com/contest/1559/problem/A
 *  Runtime : 0.202s
 */
package codeForces.round738;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MochaAndMath {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        var sb = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = nextIntArray(n, br);
            int ret = arr[0];
            for (int i = 1; i < arr.length; i++) ret &= arr[i];

            sb.append(ret).append("\n");
        }

        br.close();
        System.out.println(sb);
    }

    private static int[] nextIntArray(int N, BufferedReader br) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        return arr;
    }
}
