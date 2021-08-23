/**
 *  Problem Link: https://codeforces.com/contest/1559/problem/C
 *  Runtime: 0.202s
 */
package codeForces.problemSet.rank1200;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MochaAndHiking {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        var sb = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = nextIntArray(n, br);
            sb.append(findPath(arr)).append("\n");
        }
        br.close();
        System.out.println(sb);
    }

    private static String findPath(int arr[]) {
        int prev = 0;
        boolean pushed = false;
        var sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            if (prev == 0 && arr[i] == 1 && !pushed) {
                sb.append(arr.length + 1).append(" ");
                pushed = true;
            }
            sb.append(i + 1).append(" ");
            prev = arr[i];
        }
        if (!pushed) sb.append(arr.length + 1);
        return sb.toString();
    }

    private static int[] nextIntArray(int N, BufferedReader br) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        return arr;
    }
}
