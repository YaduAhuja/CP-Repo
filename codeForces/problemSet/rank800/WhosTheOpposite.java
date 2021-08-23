/**
 *  Problem Link : https://codeforces.com/problemset/problem/1560/B
 *  Runtime : 0.186s
 */
package codeForces.problemSet.rank800;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WhosTheOpposite {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        var sb = new StringBuilder();

        while (t-- > 0) {
            int arr[] = nextIntArray(3, br);
            sb.append(solveQuery(arr)).append("\n");
        }
        br.close();
        System.out.println(sb);
    }

    private static int solveQuery(int arr[]) {
        int ret = -1;
        int maxPossible = 2 * Math.abs(arr[1] - arr[0]);

        if (arr[1] > maxPossible || arr[0] > maxPossible || arr[2] > maxPossible) return ret;
        ret = arr[2] + maxPossible / 2;
        if (ret > maxPossible) {
            ret = arr[2] - maxPossible / 2;
        }

        return ret;
    }

    private static int[] nextIntArray(int N, BufferedReader br) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        return arr;
    }
}
