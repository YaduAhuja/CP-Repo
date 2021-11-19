/**
 * Problem Link : https://codeforces.com/problemset/problem/1574/B
 * Runtime : 0.186s
 */
package codeForces.problemSet.rank1100;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CombinatoricsHomework {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        var sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int input[] = nextIntArray(4, br);
            Arrays.sort(input, 0, 3);
            long pairSums = 0;
            pairSums = input[2] - input[0] - input[1] - 1;
            if (pairSums <= input[3] && input[3] <= input[2] + input[1] + input[0] - 3)
                sb.append("YES\n");
            else sb.append("NO\n");
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
