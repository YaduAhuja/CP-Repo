/**
 *  Problem Link : https://codeforces.com/contest/1556/problem/A
 *  Runtime : 0.218s
 */
package codeForces.problemSet.rank800;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AVarietyOfOptions {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        var sb = new StringBuilder();
        while (t-- > 0) {
            int arr[] = nextIntArray(2, br);
            if (Math.abs(arr[0] - arr[1]) % 2 == 1) {
                sb.append("-1").append("\n");
                continue;
            }
            if (arr[0] == arr[1]) {
                if (arr[0] == 0) sb.append("0").append("\n");
                else sb.append("1").append("\n");
            } else sb.append("2").append("\n");
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
