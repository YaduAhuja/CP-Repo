/**
 *  Problem Link : https://codeforces.com/contest/1573/problem/B
 *  Runtime : 0.28s
 */
package codeForces.problemSet.rank1400;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Swaps {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        var sb = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = nextIntArray(n, br);
            int b[] = nextIntArray(n, br);
            sb.append(getValue(a, b)).append("\n");
        }
        br.close();
        System.out.println(sb);
    }

    private static int getValue(int a[], int b[]) {
        int ret = (int) 1e6;
        // Storing the Even Values With their index/Swap Value
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < b.length; i++) map.put(b[i], i);

        // Minimizing the Swap Value
        for (int i = 2 * a.length - 2; i > 1; i -= 2)
            map.put(i, Math.min(map.get(i), map.get(i + 2)));

        // Minimizing the Swap Values over odd Array
        for (int i = 0; i < a.length; i++) ret = Math.min(ret, map.get(a[i] + 1) + i);

        return ret;
    }

    private static int[] nextIntArray(int N, BufferedReader br) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        return arr;
    }
}
