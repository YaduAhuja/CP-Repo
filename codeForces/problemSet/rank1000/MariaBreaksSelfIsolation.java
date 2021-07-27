/**
 * Problem Link : https://codeforces.com/problemset/problem/1358/B
 * Runtime : 0.296s
 */
package codeForces.problemSet.rank1000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class MariaBreaksSelfIsolation {
    public static void main(String args[]) throws Exception {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        var sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int arr[] = new int[Integer.parseInt(br.readLine().trim())];
            StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
            for (int j = 0; j < arr.length; j++) arr[j] = Integer.parseInt(st.nextToken());
            sb.append(countGrannies(arr)).append("\n");
        }
        br.close();
        System.out.println(sb);
    }

    private static int countGrannies(int arr[]) {
        int ret = 0;
        var map = new TreeMap<Integer, Integer>();
        for (int i : arr) map.put(i, map.getOrDefault(i, 0) + 1);
        // System.out.println(map);
        int prev = 0;
        for (int i : map.keySet()) {
            if (map.get(i) + ret + prev >= i) {
                ret += map.get(i) + prev;
                prev = 0;
            } else {
                prev += map.get(i);
            }
        }
        return ret + 1;
    }
}
